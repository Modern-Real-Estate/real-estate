package com.loinguyen1905.realestate.service.impl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.entity.CustomerEntity;
import com.loinguyen1905.realestate.entity.UserEntity;
import com.loinguyen1905.realestate.model.dto.UserDTO;
import com.loinguyen1905.realestate.repository.UserRepository;
import com.loinguyen1905.realestate.service.IUserService;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO handleGetUserByUsername(String username) {
        UserEntity user = userRepository.findUserByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Not found user by username " + username));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO handleGetUserById(UUID id) {
        UserEntity user = userRepository.findById(id)
            .orElseThrow(() -> new UsernameNotFoundException("Not found user by id " + id));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO handleUpdateUser(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdateUser'");
    }
}