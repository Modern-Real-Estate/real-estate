package com.loinguyen1905.realestate.service;

import com.loinguyen1905.realestate.entity.CustomerEntity;
import com.loinguyen1905.realestate.model.request.RegisterRequest;

public interface ICustomerService {
    public CustomerEntity handlegetUserByUsername(String username);
    public CustomerEntity createCustomer(RegisterRequest registerRequest);
}   