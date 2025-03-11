package com.example.dine_in_order.dto.request;


import com.example.dine_in_order.enums.Availabiltiy;
import com.example.dine_in_order.enums.DietType;
import com.example.dine_in_order.model.Cuisine;
import com.example.dine_in_order.model.Restaurant;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FoodRequest {

    private String itemName;

    private int price;

    private String description;

    private int stock;

    private DietType dietType;

    private String cuisines;

    private List<String> categories;
}
