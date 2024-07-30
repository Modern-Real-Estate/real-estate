package com.loinguyen1905.realestate.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.loinguyen1905.realestate.entity.UserEntity;
import com.loinguyen1905.realestate.exception.CustomException;
import com.loinguyen1905.realestate.model.dto.MyUserDetails;
import com.loinguyen1905.realestate.repository.UserRepository;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findUserByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Not found user by username " + username));
        return modelMapper.map(user, MyUserDetails.class);
    }
}