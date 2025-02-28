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
    void mapToNewUserRequest(UserRequest user,@MappingTarget User user2);
     void mapToUser(RegistrationRequest user,@MappingTarget User user2);
     UserResponse mapToUserResponse(User user) ;
}
