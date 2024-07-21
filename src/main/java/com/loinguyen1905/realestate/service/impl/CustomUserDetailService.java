package com.loinguyen1905.realestate.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.loinguyen1905.realestate.entity.CustomerEntity;
import com.loinguyen1905.realestate.model.dto.MyUserDetail;
import com.loinguyen1905.realestate.service.ICustomerService;

@Component("userDetailsService")  
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private ICustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        CustomerEntity customer = customerService.handlegetUserByUsername(username);

        if(customer == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        return MyUserDetail.builder().
            username(customer.getUsername()).
            password(customer.getPassword()).
            authorities(authorities).
            build();
    }
    
}