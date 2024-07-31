package com.loinguyen1905.realestate.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionDTO extends AbstractDTO<PermissionDTO> {
    private String name;

    private String code;

    private String apiPath;

    private String method;

    private String module;
}