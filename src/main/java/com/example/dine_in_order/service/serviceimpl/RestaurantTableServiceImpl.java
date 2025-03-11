package com.example.dine_in_order.service.serviceimpl;

import com.example.dine_in_order.dto.request.RestaurantTableRequest;
import com.example.dine_in_order.dto.response.RestaurantTableResponse;
import com.example.dine_in_order.exception.UserNotFoundByIdException;
import com.example.dine_in_order.mapper.RestaurantMapper;
import com.example.dine_in_order.mapper.RestaurantTableMapper;
import com.example.dine_in_order.model.Restaurant;
import com.example.dine_in_order.model.RestaurantTable;
import com.example.dine_in_order.repository.RestaurantRepository;
import com.example.dine_in_order.repository.RestaurantTableRepository;
import com.example.dine_in_order.service.RestaurantTableService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestaurantTableServiceImpl implements RestaurantTableService {

    private final RestaurantTableRepository restaurantTableRepository;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantTableMapper restaurantMapper;
    @Override
    public RestaurantTableResponse registerTable(RestaurantTableRequest request, long restId) {
        Restaurant restaurant = restaurantRepository.findById(restId)
                .orElseThrow(() -> new UserNotFoundByIdException("Restaurant not found"));

        RestaurantTable restaurantTable = restaurantMapper.mapToRestaurantTableEntity(request);
        restaurantTable.setRestaurant(restaurant);  // Ensure proper mapping

        restaurantTableRepository.save(restaurantTable);
        return restaurantMapper.mapToRestaurantTableResponse(restaurantTable);
    }
}
