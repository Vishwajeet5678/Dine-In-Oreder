package com.example.dine_in_order.dto.request;

import com.example.dine_in_order.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    @NotEmpty(message = "Username can not be empty")//combination of @NotBlank and @NotNull
    @NotBlank(message = "Username can not be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$",message="Username can only contain Alphabets,Numbers and Underscore")
    private String userName;
    @NotEmpty(message = "Email can not be empty")
    @NotBlank(message = "Email can not be blank")
    private String email;
    private String password;
    private String phno;
    private UserRole role;
}
