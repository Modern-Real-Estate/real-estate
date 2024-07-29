package com.loinguyen1905.realestate.service;

import java.util.UUID;

import com.loinguyen1905.realestate.model.dto.UserDTO;

public interface IUserService {
    public UserDTO handleGetUserByUsername(String username);
    public UserDTO handleGetUserById(UUID id);
    public UserDTO handleUpdateUser(UUID id);
}