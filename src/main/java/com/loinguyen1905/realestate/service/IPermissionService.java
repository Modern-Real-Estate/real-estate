package com.loinguyen1905.realestate.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.loinguyen1905.realestate.model.dto.PermissionDTO;
import com.loinguyen1905.realestate.model.request.PermissionSearchRequest;

public interface IPermissionService {
    PermissionDTO handleGetPermissions(PermissionSearchRequest permissionSearchRequest, Pageable pageable);

    PermissionDTO handleGetPermissionById(UUID id);

    PermissionDTO handleCreatePermission(PermissionDTO permissionDTO);

    PermissionDTO handleUpdatePermission(PermissionDTO permissionDTO);

    void handleDeletePermission(List<UUID> ids);
}