package com.loinguyen1905.realestate.model.dto;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleDTO extends AbstractDTO<RoleDTO> {
    private String name;
    private String code;
    private List<PermissionDTO> permissions;
    private List<String> permissionCodes;
}