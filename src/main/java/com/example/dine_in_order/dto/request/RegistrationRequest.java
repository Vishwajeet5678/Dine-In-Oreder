package com.example.dine_in_order.dto.request;

import com.example.dine_in_order.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    private String userName;
    private String email;
    private String password;
    private String phno;
    private UserRole role;
}
