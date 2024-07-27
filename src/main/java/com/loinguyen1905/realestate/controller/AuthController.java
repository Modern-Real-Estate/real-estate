package com.loinguyen1905.realestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.realestate.model.request.LoginRequest;
import com.loinguyen1905.realestate.model.request.RegisterRequest;
import com.loinguyen1905.realestate.model.response.AuthenResponse;
import com.loinguyen1905.realestate.service.IAuthService;
import com.loinguyen1905.realestate.util.annotation.APIMessage;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private IAuthService authService;

    @PostMapping("/login")
    @APIMessage(message = "Login success")
    public ResponseEntity<AuthenResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok().body(authService.login(loginRequest));
    }

    @PostMapping("/register")
    @APIMessage(message = "Register success")
    public ResponseEntity<AuthenResponse> register(@Valid @RequestBody RegisterRequest registerRequest) { 
        AuthenResponse authenResponse = authService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(authenResponse);
    }
}