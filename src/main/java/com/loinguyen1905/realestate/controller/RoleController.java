package com.loinguyen1905.realestate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.realestate.model.dto.RoleDTO;
import com.loinguyen1905.realestate.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("${release.api.prefix}/roles")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @PostMapping
    public ResponseEntity<RoleDTO> postMethodName(
        @RequestBody RoleDTO roleDTO
    ) {
        return ResponseEntity.status(201).body(this.roleService.handleCreateRole(roleDTO));
    }   
}