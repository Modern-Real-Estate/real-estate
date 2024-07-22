package com.loinguyen1905.realestate.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loinguyen1905.realestate.entity.CustomerEntity;
import com.loinguyen1905.realestate.model.request.RegisterRequest;

@Component
public class CustomerConverter {

    @Autowired
    public ModelMapper modelMapper;

    public CustomerEntity toCustomerEnity(RegisterRequest registerRequest) {
        CustomerEntity customerEntity = modelMapper.map(registerRequest, CustomerEntity.class);
        return customerEntity;
    }

}
