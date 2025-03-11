package com.example.dine_in_order.mapper;

import com.example.dine_in_order.dto.request.RestaurantTableRequest;
import com.example.dine_in_order.dto.response.RestaurantTableResponse;
import com.example.dine_in_order.model.RestaurantTable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantTableMapper {

    RestaurantTable mapToRestaurantTableEntity(RestaurantTableRequest restaurantTable);
    RestaurantTableResponse mapToRestaurantTableResponse(RestaurantTable restaurantTable);
}
