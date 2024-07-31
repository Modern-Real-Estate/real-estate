package com.loinguyen1905.realestate.model.request;

import com.loinguyen1905.realestate.model.dto.AbstractDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PermissionSearchRequest extends AbstractDTO<PermissionSearchRequest> {
    private String name;
    private String code;
    private String apiPath;
    private String method;
    private String module;
}