package com.loinguyen1905.realestate.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.loinguyen1905.realestate.model.request.LoginRequest;

@Component
public class AuthenticationUtils {
    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    public Authentication authentication(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken 
            authenticationToken = 
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        return authentication;
    }
}
