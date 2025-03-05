package com.example.dine_in_order.dto.response;

import com.example.dine_in_order.enums.DietType;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class RestaurantResponse {

    private long restaurantId;

    private String name;

    private LocalTime opensAt;


    private LocalTime closesAt;


    private List<DietType> dietType;


    private LocalDateTime createdAt;


    private LocalDateTime lastModifiedAt;

    private List<String> cuisines;
}
