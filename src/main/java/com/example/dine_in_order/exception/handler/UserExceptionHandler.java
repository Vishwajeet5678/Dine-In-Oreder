package com.example.dine_in_order.exception.handler;

import com.example.dine_in_order.exception.UserNotFoundByIdException;
import com.example.dine_in_order.util.ResponseBuilder;
import com.example.dine_in_order.util.SimpleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundByIdException.class)
    public ResponseEntity<SimpleErrorResponse> handleUserNotFoundById(UserNotFoundByIdException ex)
    {
        return ResponseBuilder.notFound("User not Found");
    }
}
