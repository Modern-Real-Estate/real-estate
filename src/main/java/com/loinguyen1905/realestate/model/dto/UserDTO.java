package com.loinguyen1905.realestate.model.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private String type;
}