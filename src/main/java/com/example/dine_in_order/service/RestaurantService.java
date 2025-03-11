package com.example.dine_in_order.service;

import com.example.dine_in_order.dto.request.RestaurantRequest;
import com.example.dine_in_order.dto.response.RestaurantResponse;

public interface RestaurantService {
    RestaurantResponse registerRestaurant(RestaurantRequest request, Long userId);
}
