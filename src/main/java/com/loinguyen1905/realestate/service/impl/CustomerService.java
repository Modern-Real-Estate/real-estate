package com.loinguyen1905.realestate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.converter.CustomerConverter;
import com.loinguyen1905.realestate.entity.CustomerEntity;
import com.loinguyen1905.realestate.model.dto.CustomerDTO;
import com.loinguyen1905.realestate.model.request.RegisterRequest;
import com.loinguyen1905.realestate.model.response.AuthenResponse;
import com.loinguyen1905.realestate.repository.CustomerRepository;
import com.loinguyen1905.realestate.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerEntity handlegetUserByUsername(String username) {
        CustomerEntity customer = customerRepository.findByEmail(username);
        return customer;
    }
}