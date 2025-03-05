package com.example.dine_in_order.mapper;

import com.example.dine_in_order.dto.request.RegistrationRequest;
import com.example.dine_in_order.dto.request.UserRequest;
import com.example.dine_in_order.dto.response.UserResponse;
import com.example.dine_in_order.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {
    /**
     * Maps a UserRequest object to an existing User entity.
     *
     * @param user The UserRequest containing updated user details.
     * @param user2 The target User entity to be updated.
     */
    void mapToNewUserRequest(UserRequest user, @MappingTarget User user2);

    /**
     * Maps a RegistrationRequest object to an existing User entity.
     *
     * @param user The RegistrationRequest containing user registration details.
     * @param user2 The target User entity to be updated.
     */
    void mapToUser(RegistrationRequest user, @MappingTarget User user2);

    /**
     * Converts a User entity into a UserResponse DTO.
     *
     * @param user The User entity to be converted.
     * @return A UserResponse DTO containing user details.
     */
     UserResponse mapToUserResponse(User user) ;
}
