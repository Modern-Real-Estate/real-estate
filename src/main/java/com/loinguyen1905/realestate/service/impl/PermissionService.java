package com.loinguyen1905.realestate.service.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.loinguyen1905.realestate.entity.PermissionEntity;
import com.loinguyen1905.realestate.exception.CustomRuntimeException;
import com.loinguyen1905.realestate.model.dto.PermissionDTO;
import com.loinguyen1905.realestate.repository.PermissionRepository;
import com.loinguyen1905.realestate.service.IPermissionService;
import com.loinguyen1905.realestate.util.OverwriteUtils;

public class PermissionService implements IPermissionService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<PermissionDTO> handleGetPermissions(PermissionDTO permissionDTO) {
        
    }

    @Override
    public PermissionDTO handleGetPermissionById(UUID id) {
        return this.modelMapper.map(
            this.permissionRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Not found permission by id " + id))
            , PermissionDTO.class
        );
    }

    @Override
    public PermissionDTO handleCreatePermission(PermissionDTO permissionDTO) {
        PermissionEntity permission = this.modelMapper.map(permissionDTO, PermissionEntity.class);
        permission = this.permissionRepository.save(permission);
        return this.modelMapper.map(permission, PermissionDTO.class);
    }

    @Override
    public PermissionDTO handleUpdatePermission(PermissionDTO permissionDTO) {
        PermissionEntity beModifiedPermission = this.permissionRepository.findById(permissionDTO.getId())
                .orElseThrow(() -> new CustomRuntimeException("Not found permission by id " + permissionDTO.getId()));
        PermissionEntity permission = this.modelMapper.map(permissionDTO, PermissionEntity.class);
        permission = OverwriteUtils.overwrireObject(permission, beModifiedPermission);
        permission = this.permissionRepository.save(permission);
        return this.modelMapper.map(permission, PermissionDTO.class);
    }

    @Override
    public void handleDeletePermission(List<UUID> ids) {
        this.permissionRepository.deleteByIdIn(ids);
    }
}