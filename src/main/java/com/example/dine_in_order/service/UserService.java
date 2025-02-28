package com.example.dine_in_order.service;

import com.example.dine_in_order.dto.request.RegistrationRequest;
import com.example.dine_in_order.dto.request.UserRequest;
import com.example.dine_in_order.dto.response.UserResponse;
import com.example.dine_in_order.model.User;

public interface UserService {
    UserResponse registerUser(RegistrationRequest user);

    UserResponse findUserById(long userId);

    UserResponse updateUserById(long userId, UserRequest user);
}
