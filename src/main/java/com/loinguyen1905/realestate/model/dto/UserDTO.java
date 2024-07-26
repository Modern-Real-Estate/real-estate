package com.loinguyen1905.realestate.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserDTO extends AbstractDTO<UserDTO> {
    private String firstName;
    private String lastName;
    private Boolean status;
    private String email;
    private String phone;
    private String type;
}