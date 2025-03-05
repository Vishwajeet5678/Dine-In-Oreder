package com.example.dine_in_order.service;

import com.example.dine_in_order.dto.request.RegistrationRequest;
import com.example.dine_in_order.dto.request.UserRequest;
import com.example.dine_in_order.dto.response.UserResponse;
import com.example.dine_in_order.model.User;

/**
 * Service interface for managing user operations.
 */
public interface UserService {

    /**
     * Registers a new user with the provided details.
     *
     * @param user Registration request containing user details.
     * @return UserResponse containing registered user information.
     */
    UserResponse registerUser(RegistrationRequest user);

    /**
     * Finds a user by their unique ID.
     *
     * @param userId The ID of the user to retrieve.
     * @return UserResponse containing user details if found.
     */
    UserResponse findUserById(long userId);

    /**
     * Updates an existing user's details by their ID.
     *
     * @param userId The ID of the user to update.
     * @param user Request containing updated user information.
     * @return UserResponse containing updated user details.
     */
    UserResponse updateUserById(long userId, UserRequest user);
}
