package com.loinguyen1905.realestate.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.converter.AuthenResponseConverter;
import com.loinguyen1905.realestate.converter.UserConverter;
import com.loinguyen1905.realestate.entity.UserEntity;
import com.loinguyen1905.realestate.exception.CustomException;
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
@Transactional
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
    @Autowired
    private AuthenResponseConverter authenResponseConverter;

    @Override
    public AuthenResponse login(LoginRequest loginRequest) {
        Authentication authenticResults = securityUtils.authentication(loginRequest);
        Pair<String, String> tokenPair = jwtUtils.createTokenPair((MyUserDetails) authenticResults.getPrincipal());
        handleUpdateUsersRefreshToken(loginRequest.getUsername(), tokenPair.getSecond());
        return authenResponseConverter
            .toAuthenResponse(modelMapper.map((MyUserDetails) authenticResults.getPrincipal(), UserEntity.class), tokenPair);
    }

    @Override
    public AuthenResponse register(RegisterRequest registerRequest) {
        UserEntity user = userConverter.toUserEntity(registerRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return authenResponseConverter.toAuthenResponse(user, null);
    }

    @Override
    public void handleUpdateUsersRefreshToken(String username, String refreshToken) {
        UserEntity user = userRepository.findUserByUsername(username)
            .orElseThrow(() -> new CustomException("Not found user with username " + username));
        user.setRefreshToken(refreshToken);
        userRepository.save(user);
    }

    @Override
    public AuthenResponse handleGetAuthenResponseByUsernameAndRefreshToken(String username, String refreshToken) {
        UserEntity user = userRepository.findByUsernameAndRefreshToken(username, refreshToken)
            .orElseThrow(() -> new CustomException("Not found user with refresh token and username " + username));
        Pair<String, String> tokenPair = jwtUtils.createTokenPair(modelMapper.map(user, MyUserDetails.class));
        handleUpdateUsersRefreshToken(username, tokenPair.getSecond());
        return authenResponseConverter.toAuthenResponse(user, tokenPair);
    }
}