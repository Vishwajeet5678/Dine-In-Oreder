package com.example.dine_in_order.model;

import com.example.dine_in_order.enums.DietType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)

public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private long restaurantId;

    @Column(name = "restaurant_name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact")
    private String contactNumber;

    @Column(name = "email")
    private String contactEmail;

    @Column(name = "opensat")
    private LocalTime opensAt;

    @Column(name = "closesat")
    private LocalTime closesAt;

    @Column(name = "diettype")
    private List<DietType> dietTypes;

    @Column(name = "createdat")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "lastmodifiedat")
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;

    @ManyToMany
    private List<Cuisine> cuisines;

    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;


    @OneToMany(mappedBy = "restaurant")
    private List<FoodItems>foodItems;
}
