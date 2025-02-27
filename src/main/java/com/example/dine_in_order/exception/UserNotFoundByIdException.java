package com.example.dine_in_order.exception;

public class UserNotFoundByIdException extends RuntimeException {
    private final String message;

    public UserNotFoundByIdException(String message) {
this.message=message;
    }
@Override
    public String getMessage()
    {
        return message;
    }
}
