package com.example.dine_in_order.mapper;

import com.example.dine_in_order.dto.request.RestaurantRequest;
import com.example.dine_in_order.dto.response.RestaurantResponse;
import com.example.dine_in_order.model.Cuisine;
import com.example.dine_in_order.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    /**
     * Maps a RestaurantRequest DTO to a Restaurant entity.
     *
     * @param restaurantRequest The request object containing restaurant details.
     * @return A Restaurant entity with the mapped values.
     */
   Restaurant mapToRestaurantEntity(RestaurantRequest restaurantRequest);

    /**
     * Converts a Restaurant entity into a RestaurantResponse DTO.
     *
     * @param  restaurant The Restaurant entity to be converted.
     * @return A RestaurantResponse DTO containing user details.
     */
    RestaurantResponse mapTORestaurantResponse(Restaurant restaurant);

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


}
