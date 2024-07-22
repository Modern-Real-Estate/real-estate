package com.loinguyen1905.realestate.controller;

import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.realestate.entity.CustomerEntity;
import com.loinguyen1905.realestate.service.impl.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{username}")
    public CustomerEntity getMethodName(
        @PathVariable("username") String username
    ) {
        CustomerEntity customer = customerService.handlegetUserByUsername(username);
        return customer;
    }
    
}