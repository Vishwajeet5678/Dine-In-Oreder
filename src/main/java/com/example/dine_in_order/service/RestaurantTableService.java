package com.example.dine_in_order.service;

import com.example.dine_in_order.dto.request.RestaurantTableRequest;
import com.example.dine_in_order.dto.response.RestaurantTableResponse;

public interface RestaurantTableService {
    RestaurantTableResponse registerTable(RestaurantTableRequest request, long restId);
}
