package com.example.dine_in_order.model;

import com.example.dine_in_order.enums.Availabiltiy;
import com.example.dine_in_order.enums.DietType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "FoodItems",indexes = {@Index(name = "idx_name",columnList = "item_name")})
@EntityListeners(AuditingEntityListener.class)
public class FoodItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    @Column(name = "stock")
    private int stock;

    @Column(name = "availability")
    private Availabiltiy availabiltiy;

    @Column(name = "diet_type")
    @Enumerated(EnumType.STRING)
    private DietType dietType;

    @Column(name = "created_at")
    @CreatedDate
    private LocalTime createdAt;

    @Column(name = "last_modified_at")
    @LastModifiedDate
    private LocalTime lastModifiedAt;

    @ManyToOne
    private Cuisine cuisines;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToMany
    private List<Category> categories;

}
