package com.example.dine_in_order.service.serviceimpl;

import com.example.dine_in_order.dto.request.RestaurantRequest;
import com.example.dine_in_order.dto.response.RestaurantResponse;
import com.example.dine_in_order.enums.UserRole;
import com.example.dine_in_order.exception.UserNotFoundByIdException;
import com.example.dine_in_order.mapper.RestaurantMapper;
import com.example.dine_in_order.mapper.UserMapper;
import com.example.dine_in_order.model.Admin;
import com.example.dine_in_order.model.Cuisine;
import com.example.dine_in_order.model.Restaurant;
import com.example.dine_in_order.model.User;
import com.example.dine_in_order.repository.CuisineRepository;
import com.example.dine_in_order.repository.RestaurantRepository;
import com.example.dine_in_order.repository.UserRepository;
import com.example.dine_in_order.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalTime;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
private final RestaurantRepository restaurantRepository;
private final UserRepository userRepository;
    private final RestaurantMapper mapper;
    private final CuisineRepository cuisineRepository;


    @Override
    public RestaurantResponse registerRestaurant(RestaurantRequest request, Long userId) {
       User user=userRepository.findById(userId).orElseThrow(()->new UserNotFoundByIdException("User Not Found"));
       if(user instanceof Admin admin)
       {

           Restaurant restaurant=mapper.mapToRestaurantEntity(request);
           List<Cuisine>cuisines=this.createCuisineTypes(restaurant.getCuisines());
           restaurant.setCuisines(cuisines);
           restaurant.setAdmin(admin);
           restaurantRepository.save(restaurant);
           return mapper.mapTORestaurantResponse(restaurant);
       }
       else {
           throw new UserNotFoundByIdException("Admin not valid");
       }
    }

    private List<Cuisine>createCuisineTypes(List<Cuisine> cuisines)
    {
        return cuisines.stream()
                .map( type->
                {
                    return cuisineRepository.findById(type.getCuisineName())
                            .orElseGet(()->cuisineRepository.save(type));
                }).toList();
    }
}
