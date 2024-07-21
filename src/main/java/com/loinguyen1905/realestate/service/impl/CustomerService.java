package com.loinguyen1905.realestate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.entity.CustomerEntity;
import com.loinguyen1905.realestate.repository.CustomerRepository;
import com.loinguyen1905.realestate.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerEntity register() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public CustomerEntity handlegetUserByUsername(String username) {
        return customerRepository.findByEmail(username);
    } 
}