package com.loinguyen1905.realestate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.realestate.common.SystemConstant;
import com.loinguyen1905.realestate.model.dto.PermissionDTO;
import com.loinguyen1905.realestate.model.request.PermissionSearchRequest;
import com.loinguyen1905.realestate.service.IPermissionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("${release.api.prefix}/permissions")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @GetMapping
    public ResponseEntity<PermissionDTO> getPermissions(
        @ModelAttribute(SystemConstant.MODEL) PermissionSearchRequest permissionSearchRequest,
        Pageable pageable
    ) {
        return ResponseEntity.ok().body(
            this.permissionService.handleGetPermissions(permissionSearchRequest, pageable)
        );
    }

    @PostMapping
    public ResponseEntity<PermissionDTO> createPermission(
        @RequestBody PermissionDTO permissionDTO
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            this.permissionService.handleCreatePermission(permissionDTO)
        );
    }
    
}