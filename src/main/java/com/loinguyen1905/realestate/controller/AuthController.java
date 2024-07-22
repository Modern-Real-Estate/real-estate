package com.loinguyen1905.realestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.realestate.entity.CustomerEntity;
import com.loinguyen1905.realestate.model.request.LoginRequest;
import com.loinguyen1905.realestate.model.request.RegisterRequest;
import com.loinguyen1905.realestate.model.response.AuthenResponse;
import com.loinguyen1905.realestate.service.ICustomerService;
import com.loinguyen1905.realestate.service.impl.AuthService;
import com.loinguyen1905.realestate.util.SecurityUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthenResponse> login(
        @Valid
        @RequestBody 
        LoginRequest loginRequest
    ) {
        return ResponseEntity.ok().body(authService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenResponse> register(
        @Valid
        @RequestBody
        RegisterRequest registerRequest
    ) { 
        AuthenResponse authenResponse = authService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(authenResponse);
    }
}