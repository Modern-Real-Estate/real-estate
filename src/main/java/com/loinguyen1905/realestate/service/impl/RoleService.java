package com.loinguyen1905.realestate.service.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.entity.PermissionEntity;
import com.loinguyen1905.realestate.entity.RoleEntity;
import com.loinguyen1905.realestate.exception.CustomRuntimeException;
import com.loinguyen1905.realestate.model.dto.RoleDTO;
import com.loinguyen1905.realestate.repository.PermissionRepository;
import com.loinguyen1905.realestate.repository.RoleRepository;
import com.loinguyen1905.realestate.service.IRoleService;
import com.loinguyen1905.realestate.util.OverwriteUtils;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public RoleDTO handleGetRoleById(UUID id) {
        RoleEntity role = this.roleRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Not found role with id " + id.toString()));
        return this.modelMapper.map(role, RoleDTO.class);
    }

    @Override
    public RoleDTO handleCreateRole(RoleDTO roleDTO) {
        RoleEntity role = this.modelMapper.map(roleDTO, RoleEntity.class);
        List<PermissionEntity> permissions = this.permissionRepository.findByCodeIn(roleDTO.getPermissionCodes());
        role.setPermissions(permissions);
        role = this.roleRepository.save(role);
        return this.modelMapper.map(role, RoleDTO.class);
    }

    @Override
    public RoleDTO handleUpdateRole(RoleDTO roleDTO) {
        RoleEntity beModifiedRole = this.roleRepository.findById(roleDTO.getId())
                .orElseThrow(() -> new CustomRuntimeException("Not found role with id " + roleDTO.getId().toString()));
        RoleEntity newRoleData = this.modelMapper.map(roleDTO, RoleEntity.class);
        beModifiedRole = this.roleRepository.save(OverwriteUtils.overwrireObject(newRoleData, beModifiedRole));
        return this.modelMapper.map(beModifiedRole, RoleDTO.class);
    }

    @Override
    public void handleDeleteRoles(List<UUID> ids) {
        this.roleRepository.deleteByIdIn(ids);
    }
}
