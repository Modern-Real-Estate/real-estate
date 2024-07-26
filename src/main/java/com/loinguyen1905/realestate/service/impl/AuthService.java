package com.loinguyen1905.realestate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.converter.UserConverter;
import com.loinguyen1905.realestate.entity.CustomerEntity;
import com.loinguyen1905.realestate.entity.UserEntity;
import com.loinguyen1905.realestate.model.request.LoginRequest;
import com.loinguyen1905.realestate.model.request.RegisterRequest;
import com.loinguyen1905.realestate.model.response.AuthenResponse;
import com.loinguyen1905.realestate.repository.UserRepository;
import com.loinguyen1905.realestate.service.IAuthService;
import com.loinguyen1905.realestate.util.JwtUtils;
import com.loinguyen1905.realestate.util.SecurityUtils;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired 
    private SecurityUtils securityUtils;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public AuthenResponse login(LoginRequest loginRequest) {
        Authentication authenticResults = securityUtils.authentication(loginRequest);
        SecurityContextHolder.getContext().setAuthentication(authenticResults);
        
        String access_token = jwtUtils.createToken(authenticResults);

        return AuthenResponse.builder()
            .accessToken(access_token)
            .email(loginRequest.getUsername())
            .build();
    }

    @Override
    public AuthenResponse register(RegisterRequest registerRequest) {
        UserEntity user = userConverter.toUserEntity(registerRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);

        return AuthenResponse.builder()
            .email(registerRequest.getEmail())
            .build();
    }

    @Override
    public void changeThePassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeThePassword'");
    }
}