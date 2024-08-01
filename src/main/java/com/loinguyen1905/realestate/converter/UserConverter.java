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
        UserEntity user = new UserEntity();
        if(object instanceof RegisterRequest registerRequest) {
            user = modelMapper.map(registerRequest, UserEntity.class);
        } else {

        }
        return user;
    }

    public UserDTO toUserDTO(UserEntity userEntity) {
        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
        return userDTO;
    }
}