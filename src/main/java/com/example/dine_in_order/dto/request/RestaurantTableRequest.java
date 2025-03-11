package com.example.dine_in_order.dto.request;

import com.example.dine_in_order.enums.TableStatus;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantTableRequest {

    private int tableNumber;

    private int tableCapacity;

    private TableStatus tableStatus;


}
