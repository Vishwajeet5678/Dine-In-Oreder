package com.example.dine_in_order.mapper;

import com.example.dine_in_order.dto.request.RegistrationRequest;
import com.example.dine_in_order.dto.request.UserRequest;
import com.example.dine_in_order.dto.response.UserResponse;
import com.example.dine_in_order.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public void mapToNewUserRequest(UserRequest user, User user2) {
        user2.setUserName(user.getUserName());
        user2.setEmail(user.getEmail());
        user2.setPhno(user.getPhno());
    }
    public void mapToUser(RegistrationRequest user, User user2){
        user2.setUserName(user.getUserName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setPhno(user.getPhno());
        user2.setRole(user.getRole());

    }
    public UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .createdAt(user.getCreateAt())
                .role(user.getRole())
                .lastModifiedAt(user.getLastModifiedAt())
                .build();
    }
}
