package com.example.dine_in_order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "admins")
public class Admin extends User{
    @OneToMany(mappedBy = "admin")
    private List<Restaurant> restaurant;
}
