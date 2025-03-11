package com.example.dine_in_order.service;

import com.example.dine_in_order.dto.request.FoodRequest;
import com.example.dine_in_order.dto.response.FoodResponse;

import java.util.List;

public interface FoodItmeService {
    FoodResponse registerFood(FoodRequest foodRequest, long restaurantId);


    List<FoodResponse> findFoodItemsByAllCategories(List<String> categories);
}
