package com.loinguyen1905.realestate.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import com.loinguyen1905.realestate.common.SystemConstant;

@Component
public class CookieUtils {
    @Value("${winnguyen1905.jwt.refresh_token-validity-in-seconds}")
    private String jwtRefreshTokenExpiration;

    public ResponseCookie creatResponseCookie(String refreshToken) {
        return ResponseCookie
            .from(SystemConstant.REFRESH_TOKEN, refreshToken)
            .httpOnly(true)
            .secure(true)
            .path("/")
            .maxAge(Long.parseLong(jwtRefreshTokenExpiration))
            .build();
    }
}