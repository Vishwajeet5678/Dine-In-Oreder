package com.example.dine_in_order.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    @NotEmpty(message = "Username can not be empty")//combination of @NotBlank and @NotNull
    @NotBlank(message = "Username can not be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$",message="Username can only contain Alphabets,Numbers and Underscore")
    private String userName;
    @NotEmpty(message = "Email can not be empty")
    @NotBlank(message = "Email can not be blank")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$",
            message = "The email should begin with letters, numbers, or allowed special characters (., _, %, +, -) and must end with \"@gmail.com")
    private String email;
    @Pattern(regexp = "^(\\+91[\\s-]?|91[\\s-]?)?[6-9]\\d{9}$",message = "The mobile number should be exactly 10 digits long and must start with a digit between 6 and 9")
    private String phno;
}
