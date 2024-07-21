package com.loinguyen1905.realestate.model.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder    
public class LoginRequest {

    @NotBlank(message = "username not blank")
    private String username;

    @NotBlank(message = "password not blank")
    private String password;

}