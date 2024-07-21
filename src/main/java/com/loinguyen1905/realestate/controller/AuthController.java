package com.loinguyen1905.realestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.realestate.model.request.LoginRequest;

import jakarta.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/login/")
    public ResponseEntity<LoginRequest> login(
        @Valid
        @RequestBody 
        LoginRequest loginRequest
    ) {
        UsernamePasswordAuthenticationToken authenticationToken
        = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        // Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        return ResponseEntity.ok().body(loginRequest);
    }

    @PostMapping("path")
    public String postMethodName(@RequestBody String entity) { 
        //TODO: process POST request
        
        return entity;
    }
    

}