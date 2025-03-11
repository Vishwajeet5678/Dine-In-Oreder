package com.example.dine_in_order.controller;

import com.example.dine_in_order.dto.request.RestaurantTableRequest;
import com.example.dine_in_order.dto.response.RestaurantTableResponse;
import com.example.dine_in_order.model.RestaurantTable;
import com.example.dine_in_order.service.RestaurantTableService;
import com.example.dine_in_order.util.ResponseBuilder;
import com.example.dine_in_order.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${app.base-url}")
public class RestaurantTableController {

    private final RestaurantTableService restaurantTableService;

    @PostMapping("/table/{restaurantId}")
    public ResponseEntity<ResponseStructure<RestaurantTableResponse>> registerTable(@RequestBody RestaurantTableRequest request, @PathVariable long restaurantId)
    {
        RestaurantTableResponse response=restaurantTableService.registerTable(request,restaurantId);
        return ResponseBuilder.create(response,"Table Created");
    }
}
