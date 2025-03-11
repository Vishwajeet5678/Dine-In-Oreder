package com.example.dine_in_order.mapper;

import com.example.dine_in_order.dto.request.FoodRequest;
import com.example.dine_in_order.dto.response.FoodResponse;
import com.example.dine_in_order.dto.response.RestaurantResponse;
import com.example.dine_in_order.model.Category;
import com.example.dine_in_order.model.Cuisine;
import com.example.dine_in_order.model.FoodItems;
import com.example.dine_in_order.model.Restaurant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodItemsMapper {

    FoodItems mapToFoodItemsEntity(FoodRequest foodRequest);

    FoodResponse mapToFoodResponse(FoodItems foodItems);
    List<Category> mapToListOfCategory(List<String> categories);
    List<FoodResponse> mapToFoodItemResponseList(List<FoodItems> foodItems);
    default String mapToStringCuisine(Cuisine cuisines){
        if ( cuisines == null ) {
            return null;
        }

        return  cuisines.getCuisineName();
    }
    default Cuisine mapToCuisineType(String cuisines)
    {
        if ( cuisines == null ) {
            return null;
        }

        Cuisine cuisine = new Cuisine();
        cuisine.setCuisineName(cuisines);
        return cuisine;
    }


    default String mapToStringCategory(Category category){
        if ( category == null ) {
            return null;
        }

        return  category.getCategory();
    }
    default Category mapToCategoryType(String category)
    {
        if ( category == null ) {
            return null;
        }

        Category category1 = new Category();
        category1.setCategory(category);
        return category1;
    }



}