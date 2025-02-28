package com.example.dine_in_order.controller;

import com.example.dine_in_order.dto.request.RegistrationRequest;
import com.example.dine_in_order.dto.request.UserRequest;
import com.example.dine_in_order.dto.response.UserResponse;
import com.example.dine_in_order.model.User;
import com.example.dine_in_order.service.UserService;
import com.example.dine_in_order.util.ResponseBuilder;
import com.example.dine_in_order.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.stream.DoubleStream.builder;

@RestController
@AllArgsConstructor
public class UserController {

    private  final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody RegistrationRequest user)
    {
        UserResponse response=userService.registerUser(user);
        return ResponseBuilder.sucess(HttpStatus.CREATED,"User Created",response);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable("userId") long userId)
    {
        UserResponse user=userService.findUserById(userId);
        return ResponseBuilder.sucess(HttpStatus.OK,"User Found",user);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUserById(@PathVariable("userId")long userId,@RequestBody UserRequest user)
    {
         UserResponse response=userService.updateUserById(userId,user);
        return ResponseBuilder.sucess(HttpStatus.OK,"User Updated",response);
    }


}
