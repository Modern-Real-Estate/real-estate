package com.loinguyen1905.realestate.service;

import com.loinguyen1905.realestate.model.dto.UserDTO;

public interface IUserService {
    public UserDTO handlegetUserByUsername(String username);
}   