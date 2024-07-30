package com.loinguyen1905.realestate.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import com.loinguyen1905.realestate.entity.UserEntity;
import com.loinguyen1905.realestate.model.dto.UserDTO;
import com.loinguyen1905.realestate.model.response.AuthenResponse;

@Component
public class AuthenResponseConverter {
    @Autowired
    public ModelMapper modelMapper;

    public AuthenResponse toAuthenResponse(UserEntity user, Pair<String, String> tokenPair) {
        if (tokenPair == null)
            return AuthenResponse.builder().userDTO(modelMapper.map(user, UserDTO.class)).build();
        return AuthenResponse.builder()
                .userDTO(modelMapper.map(user, UserDTO.class))
                .accessToken(tokenPair.getFirst())
                .refreshToken(tokenPair.getSecond())
                .build();
    }
}