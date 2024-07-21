package com.loinguyen1905.realestate.service;

import com.loinguyen1905.realestate.entity.CustomerEntity;

public interface ICustomerService {
    public CustomerEntity handlegetUserByUsername(String username);
}   