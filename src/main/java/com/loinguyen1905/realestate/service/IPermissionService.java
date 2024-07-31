package com.loinguyen1905.realestate.service;

import java.util.List;
import java.util.UUID;

import com.loinguyen1905.realestate.model.dto.PermissionDTO;

public interface IPermissionService {
    List<PermissionDTO> handleGetPermissions(PermissionDTO permissionDTO);
    PermissionDTO handleGetPermissionById(UUID id);
    PermissionDTO handleCreatePermission(PermissionDTO permissionDTO);
    PermissionDTO handleUpdatePermission(PermissionDTO permissionDTO);
    void handleDeletePermission(List<UUID> ids);
}