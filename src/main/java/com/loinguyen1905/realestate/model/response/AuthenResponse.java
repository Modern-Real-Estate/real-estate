package com.loinguyen1905.realestate.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenResponse {
    private String email;
    private Long id;
    private String accessToken;
    private String refeshToken;
}