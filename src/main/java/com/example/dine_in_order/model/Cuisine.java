package com.example.dine_in_order.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cuisine {
    @Id
    @Column(name = "cuisineName")
    private String cuisineName;
    @ManyToMany
    private List<Restaurant> restaurant;
}
