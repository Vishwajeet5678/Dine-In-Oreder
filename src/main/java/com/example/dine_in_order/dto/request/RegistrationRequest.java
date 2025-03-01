package com.example.dine_in_order.dto.request;

import com.example.dine_in_order.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    @NotNull
    @NotBlank
    private String userName;
    private String email;
    private String password;
    private String phno;
    private UserRole role;
}
