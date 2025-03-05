package com.example.dine_in_order.model;

import com.example.dine_in_order.enums.DietType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "restaurant")
@Getter
@Setter

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
    private DietType dietType;

    @Column(name = "createdat")
    private LocalDateTime createdAt;

    @Column(name = "lastmodifiedat")
    private LocalDateTime lastModifiedAt;

    @ManyToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    private List<Cuisine> cuisine;



}
