package com.example.dine_in_order.dto.request;

import com.example.dine_in_order.enums.UserRole;
import jakarta.validation.constraints.*;
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
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$",
            message = "The email should begin with letters, numbers, or allowed special characters (., _, %, +, -) and must end with \"@gmail.com")
    private String email;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,12}$",
            message = "The password must be between 8 to 12 characters long and must include at least one uppercase letter, one lowercase letter, one number, and one special character.")
    @NotEmpty(message = "Password can not be empty")
    @NotBlank(message = "Password can not be blank")
    private String password;
    @Pattern(regexp = "^(\\+91[\\s-]?|91[\\s-]?)?[6-9]\\d{9}$",message = "The mobile number should be exactly 10 digits long and must start with a digit between 6 and 9")
    private String phno;
    private UserRole role;
}
