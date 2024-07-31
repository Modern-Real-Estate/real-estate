package com.loinguyen1905.realestate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("${release.api.prefix}/permissions")
public class PermissionController {
    @PostMapping
    public String createPermission(
        
    ) {
        
        return entity;
    }
    
}