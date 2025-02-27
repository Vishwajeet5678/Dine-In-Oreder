package com.example.dine_in_order.repository;

import com.example.dine_in_order.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
