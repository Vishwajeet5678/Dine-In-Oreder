package com.example.dine_in_order.dto.response;


import com.example.dine_in_order.enums.Availabiltiy;
import com.example.dine_in_order.enums.DietType;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class FoodResponse {

    private String itemName;

    private int price;


    private String description;


    private Availabiltiy availabiltiy;


    private DietType dietType;

    private String cuisines;

    private LocalTime createdAt;

    private LocalTime lastModifiedAt;

    private List<String> categories;

}
