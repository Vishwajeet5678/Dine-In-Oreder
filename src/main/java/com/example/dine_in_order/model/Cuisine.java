package com.example.dine_in_order.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Cuisine {
    @Id
    @Column(name = "cuisineName")
    private String cuisineName;
    @ManyToMany(mappedBy = "cuisines", fetch = FetchType.EAGER)
    private List<Restaurant> restaurant;

    @OneToMany(mappedBy = "cuisines")
    private List<FoodItems> foodItems;


}
