package com.example.dine_in_order.repository;

import com.example.dine_in_order.model.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine,String> {
}
