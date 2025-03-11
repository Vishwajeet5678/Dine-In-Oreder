package com.example.dine_in_order.repository;

import com.example.dine_in_order.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable,Long> {
}
