package com.example.dine_in_order.util;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SimpleErrorResponse {
    private String type;
    private int status;
    private String message;
}
