package com.loinguyen1905.realestate.model.response;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenResponse {
    private UUID id;
    private String email;
    private String accessToken;
    private String refreshToken;
}