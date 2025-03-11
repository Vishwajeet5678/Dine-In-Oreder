package com.example.dine_in_order.dto.request;

import com.example.dine_in_order.enums.DietType;
import com.example.dine_in_order.model.Cuisine;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class RestaurantRequest {

    @NotEmpty(message = "Restaurant name can not be empty")//combination of @NotBlank and @NotNull
    @NotBlank(message = "Restaurant name can not be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$",message="Restaurant name can only contain Alphabets,Numbers and Underscore")
    private String name;

    private String address;

    @NotEmpty(message = "Contact can not be empty")
    @NotBlank(message = "Contact can not be blank")
    @Pattern(regexp = "^(\\+91[\\s-]?|91[\\s-]?)?[6-9]\\d{9}$",message = "The mobile number should be exactly 10 digits long and must start with a digit between 6 and 9")
    private String contactNumber;

    @NotEmpty(message = "Email can not be empty")
    @NotBlank(message = "Email can not be blank")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$",
            message = "The email should begin with letters, numbers, or allowed special characters (., _, %, +, -) and must end with \"@gmail.com")
    private String contactEmail;


    private LocalTime opensAt;


    private LocalTime closesAt;


    private List<DietType> dietTypes;

    private List<String> cuisines;

}
