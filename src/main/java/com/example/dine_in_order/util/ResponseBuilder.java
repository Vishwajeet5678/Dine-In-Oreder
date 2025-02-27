package com.example.dine_in_order.util;

import com.example.dine_in_order.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {
    public static <T>ResponseEntity<ResponseStructure<T>> sucess(HttpStatus status, String message, T data) {
        ResponseStructure<T> structure=ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(structure);
    }
    public static <T>ResponseEntity<ResponseStructure<T>> sucess(HttpStatus status, HttpHeaders headers, String message, T data) {
        ResponseStructure<T> structure=ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body(structure);
    }
}
