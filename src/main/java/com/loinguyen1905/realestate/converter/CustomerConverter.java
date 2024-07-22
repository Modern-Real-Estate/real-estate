package com.loinguyen1905.realestate.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loinguyen1905.realestate.entity.CustomerEntity;
import com.loinguyen1905.realestate.model.dto.CustomerDTO;
import com.loinguyen1905.realestate.model.request.RegisterRequest;

@Component
public class CustomerConverter {

    @Autowired
    public ModelMapper modelMapper;

    public <T> CustomerEntity toCustomerEnity(T object) {
        CustomerEntity customerEntity = null;
        if(object instanceof CustomerDTO) {
            customerEntity = modelMapper.map((CustomerDTO) object, CustomerEntity.class);
        } else if(object instanceof RegisterRequest) {
            customerEntity = modelMapper.map((RegisterRequest) object, CustomerEntity.class);
        }
        return customerEntity;
    }

    public CustomerDTO toCustomerDTO(CustomerEntity customerEntity) {
        CustomerDTO customerDTO = modelMapper.map(customerEntity, CustomerDTO.class);
        return customerDTO;
    }

}