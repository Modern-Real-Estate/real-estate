package com.loinguyen1905.realestate.service;

import com.loinguyen1905.realestate.entity.CustomerEntity;
import com.loinguyen1905.realestate.model.dto.CustomerDTO;
import com.loinguyen1905.realestate.model.request.RegisterRequest;
import com.loinguyen1905.realestate.model.response.AuthenResponse;

public interface ICustomerService {
    public CustomerEntity handlegetUserByUsername(String username);
}   