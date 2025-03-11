package com.example.dine_in_order.service.serviceimpl;

import com.example.dine_in_order.dto.request.FoodRequest;
import com.example.dine_in_order.dto.response.FoodResponse;
import com.example.dine_in_order.exception.UserNotFoundByIdException;
import com.example.dine_in_order.mapper.FoodItemsMapper;
import com.example.dine_in_order.model.Category;
import com.example.dine_in_order.model.Cuisine;
import com.example.dine_in_order.model.FoodItems;
import com.example.dine_in_order.model.Restaurant;
import com.example.dine_in_order.repository.CaategoryRepository;
import com.example.dine_in_order.repository.CuisineRepository;
import com.example.dine_in_order.repository.FoodItemsRepository;
import com.example.dine_in_order.repository.RestaurantRepository;
import com.example.dine_in_order.service.FoodItmeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FoodItemService implements FoodItmeService {

    private final FoodItemsRepository foodItemsRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodItemsMapper foodItemsMapper;
    private final CuisineRepository cuisineRepository;
    private final CaategoryRepository caategoryRepository;
    @Override
    public FoodResponse registerFood(FoodRequest foodRequest, long restaurantId) {
        Restaurant restaurant=restaurantRepository.findById(restaurantId)
                .orElseThrow(()->new UserNotFoundByIdException("User Not Found"));


        FoodItems foodItems=foodItemsMapper.mapToFoodItemsEntity(foodRequest);
        Cuisine cuisine=foodItems.getCuisines();
        cuisineRepository.findById(cuisine.getCuisineName())
                        .orElseGet(()->
                        {     cuisineRepository.save(cuisine);
                                restaurant.getCuisines().add(cuisine);
                              restaurantRepository.save(restaurant);
                              return cuisine;
                                });

        foodItems.setCategories(this.createNotExistingCategory(foodItems.getCategories()));
        foodItems.setRestaurant(restaurant);
        foodItems.setCuisines((cuisine));
        foodItemsRepository.save(foodItems);
        return foodItemsMapper.mapToFoodResponse(foodItems);
    }



    @Override
    public List<FoodResponse> findFoodItemsByAllCategories(List<String> categories) {
        List<String> categoryNames = categories.stream().distinct().toList(); // Remove duplicates
        long categoryCount = categoryNames.size();

        List<FoodItems> foodItems = caategoryRepository.findFoodItemsByAllCategories(categoryNames, categoryCount);

        return  foodItems.stream()
                .map(foodItemsMapper::mapToFoodResponse)
                .toList();
    }


    private List<Category> createNotExistingCategory(List<Category> categories) {
        return
                categories.stream().map(type->
                        caategoryRepository.findById(type.getCategory())
                                .orElseGet(()->caategoryRepository.save(type)))
                        .toList();
    }


}
