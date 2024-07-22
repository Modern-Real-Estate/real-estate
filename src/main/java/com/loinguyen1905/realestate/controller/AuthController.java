package com.loinguyen1905.realestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.loinguyen1905.realestate.util.SecurityUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;
    
    @Autowired
    private SecurityUtil securityUtil;

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<AuthenResponse> login(
        @Valid
        @RequestBody 
        LoginRequest loginRequest
    ) {
        UsernamePasswordAuthenticationToken authenticationToken
        = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        String access_token = securityUtil.createToken(authentication);
        AuthenResponse authenResponse = AuthenResponse.builder().
            email(loginRequest.getUsername()).
            accessToken(access_token).
            build();
        return ResponseEntity.ok().body(authenResponse); 
    }

    @PostMapping("/register")
    public CustomerEntity postMethodName(
        @Valid
        @RequestBody
        RegisterRequest registerRequest
    ) { 
        CustomerEntity customerEntity = customerService.createCustomer(registerRequest);
        return customerEntity;
    }
}