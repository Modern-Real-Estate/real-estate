package com.loinguyen1905.realestate.model.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder    
public class LoginRequest {
    @Email(message = "email have type example@email.com")
    @NotBlank(message = "username invalid")
    private String username;

    @Size(min = 8, max = 20, message = "password's size must >= 8")
    @NotBlank(message = "password invalid")
    private String password;
}