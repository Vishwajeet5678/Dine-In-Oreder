package com.example.dine_in_order.dto.response;

import com.example.dine_in_order.enums.TableStatus;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantTableResponse {


    private int tableNumber;


    private int tableCapacity;


    private TableStatus tableStatus;
}
