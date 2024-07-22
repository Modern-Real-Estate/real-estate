package com.loinguyen1905.realestate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.converter.CustomerConverter;
import com.loinguyen1905.realestate.entity.CustomerEntity;
import com.loinguyen1905.realestate.model.request.LoginRequest;
import com.loinguyen1905.realestate.model.request.RegisterRequest;
import com.loinguyen1905.realestate.model.response.AuthenResponse;
import com.loinguyen1905.realestate.repository.CustomerRepository;
import com.loinguyen1905.realestate.util.SecurityUtil;

@Service
public class AuthService {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired 
    private SecurityUtil securityUtil;

    public AuthenResponse login(LoginRequest loginRequest) {
        Authentication authenticResults = securityUtil.authentication(loginRequest);
        String access_token = securityUtil.createToken(authenticResults);
        SecurityContextHolder.getContext().setAuthentication(authenticResults);
        return AuthenResponse.builder()
                .accessToken(access_token)
                .email(loginRequest.getUsername())
                .build();
    }

    public AuthenResponse register(RegisterRequest registerRequest) {

        CustomerEntity customerEntity = customerConverter.toCustomerEnity(registerRequest);
        customerEntity.setPassword(passwordEncoder.encode(customerEntity.getPassword()));
        customerEntity = customerRepository.save(customerEntity);

        return AuthenResponse.builder()
                .email(registerRequest.getEmail())
                .build();
    }
}
