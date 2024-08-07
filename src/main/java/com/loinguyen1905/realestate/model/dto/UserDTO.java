package com.loinguyen1905.realestate.model.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO extends AbstractDTO<UserDTO> {
    private UUID id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean status;
    private String phone;
    @JsonProperty("role")
    private RoleDTO role;
    private String type;
}