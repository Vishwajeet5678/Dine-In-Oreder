package com.example.dine_in_order.controller;

import com.example.dine_in_order.model.User;
import com.example.dine_in_order.service.UserService;
import com.example.dine_in_order.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private  final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User user)
    {
        user=userService.registerUser(user);
        ResponseStructure<User> structure=new ResponseStructure<User>();
        structure.setData(user);
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("User Created");
        return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
    }
}
