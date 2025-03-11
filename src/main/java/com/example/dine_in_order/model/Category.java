package com.example.dine_in_order.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @Column(name = "category")
    private String category;

    @ManyToMany(mappedBy = "categories")
    private List<FoodItems> foodItems;
}
