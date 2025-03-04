package com.example.dine_in_order.controller;

import com.example.dine_in_order.dto.request.RegistrationRequest;
import com.example.dine_in_order.dto.request.UserRequest;
import com.example.dine_in_order.dto.response.UserResponse;
import com.example.dine_in_order.model.User;
import com.example.dine_in_order.service.UserService;
import com.example.dine_in_order.util.FieldErrorResponse;
import com.example.dine_in_order.util.ResponseBuilder;
import com.example.dine_in_order.util.ResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.stream.DoubleStream.builder;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Tag(name = "User Controller",description = "Collection API Endpoints dealing with the user data")
public class UserController {

    private  final UserService userService;
    @PostMapping("/register")
    @Operation(description = """
            Collection API Endpoint is used to register user.
            The endpoint requires the user to select one of the specified role along with the other details.
            """,
    responses = {
            @ApiResponse(responseCode = "201",description = "User Created"),
            @ApiResponse(responseCode = "400",description = "Invalid input",content = {
                    @Content(schema = @Schema(implementation = FieldErrorResponse.class))
            })
    })
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody @Valid RegistrationRequest user)
    {
        UserResponse response=userService.registerUser(user);
        return ResponseBuilder.sucess(HttpStatus.CREATED,"User Created",response);
    }
    @GetMapping("/{userId}")
    @Operation(description = """
            Collection API Endpoint is used to get the user.
            The endpoint requires the user to enter the userid based on the id the user details will fetch.
            """,
            responses = {
                    @ApiResponse(responseCode = "200",description = "User Found"),
                    @ApiResponse(responseCode = "400",description = "Invalid input",content = {
                            @Content(schema = @Schema(implementation = FieldErrorResponse.class))
                    })
            })
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable("userId") long userId)
    {
        UserResponse user=userService.findUserById(userId);
        return ResponseBuilder.sucess(HttpStatus.OK,"User Found",user);
    }
    @PutMapping("/{userId}")
    @Operation(description = """
            Collection API Endpoint is used to register user.
            The endpoint requires the user to select one of the specified role along with the other details.
            """,
            responses = {
                    @ApiResponse(responseCode = "200",description = "User Updated"),
                    @ApiResponse(responseCode = "400",description = "Invalid input",content = {
                            @Content(schema = @Schema(implementation = FieldErrorResponse.class))
                    })
            })
    public ResponseEntity<ResponseStructure<UserResponse>> updateUserById(@PathVariable("userId")long userId,@RequestBody @Valid UserRequest user)
    {
         UserResponse response=userService.updateUserById(userId,user);
        return ResponseBuilder.sucess(HttpStatus.OK,"User Updated",response);
    }


}
