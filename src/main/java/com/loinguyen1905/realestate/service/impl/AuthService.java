package com.loinguyen1905.realestate.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.converter.UserConverter;
import com.loinguyen1905.realestate.entity.UserEntity;
import com.loinguyen1905.realestate.model.dto.MyUserDetails;
import com.loinguyen1905.realestate.model.dto.UserDTO;
import com.loinguyen1905.realestate.model.request.LoginRequest;
import com.loinguyen1905.realestate.model.request.RegisterRequest;
import com.loinguyen1905.realestate.model.response.AuthenResponse;
import com.loinguyen1905.realestate.repository.UserRepository;
import com.loinguyen1905.realestate.service.IAuthService;
import com.loinguyen1905.realestate.util.JwtUtils;
import com.loinguyen1905.realestate.util.SecurityUtils;

import jakarta.transaction.Transactional;

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
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AuthenResponse login(LoginRequest loginRequest) {
        Authentication authenticResults = securityUtils.authentication(loginRequest);
        ((MyUserDetails) authenticResults.getPrincipal()).setPassword(null);
        SecurityContextHolder.getContext().setAuthentication(authenticResults);
        
        Pair<String, String> tokenPair = jwtUtils.createTokenPair(authenticResults);
        AuthenResponse authResponse = AuthenResponse.builder()
            .accessToken(tokenPair.getFirst())
            .refreshToken(tokenPair.getSecond())
            .build();
        if(authenticResults.getPrincipal() instanceof MyUserDetails myUserDetails)
            authResponse.setUserDTO(modelMapper.map(myUserDetails, UserDTO.class));
        return authResponse;
    }

    @Override
    @Transactional
    public AuthenResponse register(RegisterRequest registerRequest) {
        UserEntity user = userConverter.toUserEntity(registerRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return AuthenResponse.builder()
            .userDTO(modelMapper.map(user, UserDTO.class))
            .build();
    }

    @Override
    public void changeThePassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeThePassword'");
    }
}