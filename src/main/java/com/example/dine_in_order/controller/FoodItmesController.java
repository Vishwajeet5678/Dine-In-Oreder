package com.example.dine_in_order.controller;

import com.example.dine_in_order.dto.request.FoodRequest;
import com.example.dine_in_order.dto.response.FoodResponse;
import com.example.dine_in_order.model.FoodItems;
import com.example.dine_in_order.service.FoodItmeService;
import com.example.dine_in_order.util.ResponseBuilder;
import com.example.dine_in_order.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("${app.base-url}")
public class FoodItmesController {

    private final FoodItmeService foodItmeService;
    @PostMapping("/{restaurantId}")
    public ResponseEntity<ResponseStructure<FoodResponse>> registerFood(@RequestBody FoodRequest foodRequest, @PathVariable long restaurantId)
    {
        FoodResponse foodResponse=foodItmeService.registerFood(foodRequest,restaurantId);
        return ResponseBuilder.create(foodResponse,"Items Added");
    }

    @GetMapping("/foodItems")
    public ResponseEntity<ResponseStructure<List<FoodResponse>>> findFoodItemsByAllCategories(
            @RequestParam List<String> categories) {

        List<FoodResponse> foodItems = foodItmeService.findFoodItemsByAllCategories(categories);

        if (foodItems.isEmpty()) {
            return ResponseBuilder.ok(foodItems, "No food items found matching all categories");
        }

        return ResponseBuilder.ok(foodItems, "Found food items matching all categories");
    }
}
