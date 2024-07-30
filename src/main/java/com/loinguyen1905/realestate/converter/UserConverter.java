package com.loinguyen1905.realestate.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loinguyen1905.realestate.entity.UserEntity;
import com.loinguyen1905.realestate.model.dto.UserDTO;
import com.loinguyen1905.realestate.model.request.RegisterRequest;

@Component
public class UserConverter {
    @Autowired
    public ModelMapper modelMapper;

    public <T> UserEntity toUserEntity(T object) {
        UserEntity userEntity = null;
        if (object instanceof UserDTO userDTO) {
            if (userDTO.getType() == "customer") {

            } else if (userDTO.getType() == "staff") {

            }
        } else if (object instanceof RegisterRequest registerRequest) {
            userEntity = modelMapper.map(registerRequest, UserEntity.class);
        }
        return userEntity;
    }

    public UserDTO toUserDTO(UserEntity userEntity) {
        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
        return userDTO;
    }
}