package com.example.dine_in_order.repository;

import com.example.dine_in_order.model.FoodItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemsRepository extends JpaRepository<FoodItems,Long> {
}
