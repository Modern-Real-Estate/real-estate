package com.loinguyen1905.realestate.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
public class RegisterRequest {
    @NotBlank
    @Email
    private String email;

    @Size(min = 8, message = "password length must > 7")
    private String password;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
}