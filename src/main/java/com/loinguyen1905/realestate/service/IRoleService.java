package com.loinguyen1905.realestate.service;

import java.util.List;
import java.util.UUID;

import com.loinguyen1905.realestate.model.dto.RoleDTO;

public interface IRoleService {
    // RoleDTO handleGetRoles(RoleSearchRequest RoleSearchRequest, Pageable pageable);

    RoleDTO handleGetRoleById(UUID id);

    RoleDTO handleCreateRole(RoleDTO roleDTO);

    RoleDTO handleUpdateRole(RoleDTO roleDTO);

    void handleDeleteRoles(List<UUID> ids);
}