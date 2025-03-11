package com.example.dine_in_order.controller;

import com.example.dine_in_order.dto.request.RestaurantRequest;
import com.example.dine_in_order.dto.response.RestaurantResponse;
import com.example.dine_in_order.service.RestaurantService;
import com.example.dine_in_order.util.ResponseBuilder;
import com.example.dine_in_order.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${app.base-url}")
public class RestaurantController {

    private final RestaurantService restaurantService;
    @PostMapping("/registerRestaurant/{userId}")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> registerRestaurant(@RequestBody RestaurantRequest request,@PathVariable Long userId)
    {
        RestaurantResponse response=restaurantService.registerRestaurant(request,userId);
        return ResponseBuilder.create(response,"Restaurant Created");
    }

}
