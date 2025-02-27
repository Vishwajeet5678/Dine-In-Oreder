package com.example.dine_in_order.controller;

import com.example.dine_in_order.model.User;
import com.example.dine_in_order.service.UserService;
import com.example.dine_in_order.util.ResponseBuilder;
import com.example.dine_in_order.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static java.util.stream.DoubleStream.builder;

@RestController
@AllArgsConstructor
public class UserController {

    private  final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User user)
    {
        user=userService.registerUser(user);
        return ResponseBuilder.sucess(HttpStatus.CREATED,"User Created",user);
    }

}
