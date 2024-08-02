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
import com.loinguyen1905.realestate.entity.RoleEntity;
import com.loinguyen1905.realestate.entity.UserEntity;
import com.loinguyen1905.realestate.exception.CustomRuntimeException;
import com.loinguyen1905.realestate.model.dto.MyUserDetails;
import com.loinguyen1905.realestate.model.dto.UserDTO;
import com.loinguyen1905.realestate.model.request.LoginRequest;
import com.loinguyen1905.realestate.model.request.RegisterRequest;
import com.loinguyen1905.realestate.model.response.AuthenResponse;
import com.loinguyen1905.realestate.repository.RoleRepository;
import com.loinguyen1905.realestate.repository.UserRepository;
import com.loinguyen1905.realestate.service.IAuthService;
import com.loinguyen1905.realestate.util.AuthenticationUtils;
import com.loinguyen1905.realestate.util.JwtUtils;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthService implements IAuthService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final ModelMapper modelMapper;
    private final AuthenResponseConverter authenResponseConverter;
    private final RoleRepository roleRepository;
    private final AuthenticationUtils authenticationUtils;

    public AuthService(UserRepository userRepository,
        UserConverter userConverter,
        AuthenticationUtils authenticationUtils,
        PasswordEncoder passwordEncoder,
        JwtUtils jwtUtils,
        ModelMapper modelMapper,
        AuthenResponseConverter authenResponseConverter,
        RoleRepository roleRepository
    ) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.authenticationUtils = authenticationUtils;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.modelMapper = modelMapper;
        this.authenResponseConverter = authenResponseConverter;
        this.roleRepository = roleRepository;
    }


    @Override
    public AuthenResponse handleLogin(LoginRequest loginRequest) {
        Authentication authenticResults = this.authenticationUtils.authentication(loginRequest);
        Pair<String, String> tokenPair = this.jwtUtils.createTokenPair((MyUserDetails) authenticResults.getPrincipal());
        handleUpdateUsersRefreshToken(loginRequest.getUsername(), tokenPair.getSecond());
        return authenResponseConverter
                .toAuthenResponse(this.modelMapper.map((MyUserDetails) authenticResults.getPrincipal(), UserEntity.class),
                        tokenPair);
    }

    @Override
    public AuthenResponse handleRegister(RegisterRequest registerRequest) {
        UserEntity user = this.userConverter.toUserEntity(registerRequest);
        RoleEntity customerRole = this.modelMapper.map(this.roleRepository.findByCode("admin"), RoleEntity.class);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setRole(customerRole);
        user = this.userRepository.save(user);
        return this.authenResponseConverter.toAuthenResponse(user, null);
    }

    @Override
    public Void handleUpdateUsersRefreshToken(String username, String refreshToken) {
        UserEntity user = this.userRepository.findUserByUsername(username)
                .orElseThrow(() -> new CustomRuntimeException("Not found user with username " + username));
        user.setRefreshToken(refreshToken);
        this.userRepository.save(user);
        return null;
    }

    @Override
    public AuthenResponse handleGetAuthenResponseByUsernameAndRefreshToken(String username, String refreshToken) {
        UserEntity user = this.userRepository.findByUsernameAndRefreshToken(username, refreshToken)
                .orElseThrow(() -> new CustomRuntimeException("Not found user with refresh token and username " + username));
        Pair<String, String> tokenPair = this.jwtUtils.createTokenPair(this.modelMapper.map(user, MyUserDetails.class));
        handleUpdateUsersRefreshToken(username, tokenPair.getSecond());
        return this.authenResponseConverter.toAuthenResponse(user, tokenPair);
    }

    @Override
    public Void handleLogout(String username) {
        UserEntity user = this.userRepository.findUserByUsername(username)
                .orElseThrow(() -> new CustomRuntimeException("Not found user with username " + username));
        user.setRefreshToken(null);
        this.userRepository.save(user);
        return null;
    }
}