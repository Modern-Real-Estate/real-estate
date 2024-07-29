package com.loinguyen1905.realestate.util;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.util.Pair;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import com.loinguyen1905.realestate.model.dto.MyUserDetails;

@Component
@PropertySource("classpath:application-dev.properties")
public class JwtUtils {
    public static final MacAlgorithm JWT_ALGORITHM = MacAlgorithm.HS256;
    @Autowired
    private JwtEncoder jwtEncoder;
    @Value("${realestate.jwt.access_token-validity-in-seconds}")
    private String jwtAccessTokenExpiration;
    @Value("${realestate.jwt.refresh_token-validity-in-seconds}")
    private String jwtRefreshTokenExpiration;
    
    public JwtClaimsSet createJwtClaimsSet(MyUserDetails myUserDetails, Instant now, Instant validity) {
        return JwtClaimsSet.builder()
            .issuedAt(now)
            .expiresAt(validity)
            .subject(myUserDetails.getUsername())
            .claim("user", myUserDetails)
            .build();
    }

    public Pair<String, String> createTokenPair(MyUserDetails myUserDetails) {
        myUserDetails.setPassword(null);
        Instant
            now = Instant.now(),
            accessTokenValidity = now.plus(Long.parseLong(jwtAccessTokenExpiration), ChronoUnit.SECONDS), 
            refreshTokenValidity = now.plus(Long.parseLong(jwtRefreshTokenExpiration), ChronoUnit.SECONDS);
        JwsHeader jwsHeader = JwsHeader.with(JWT_ALGORITHM).build();
        String
            accessToken = jwtEncoder.encode(JwtEncoderParameters
                .from(jwsHeader, createJwtClaimsSet(myUserDetails, now, accessTokenValidity))).getTokenValue(),
            refreshToken =jwtEncoder.encode(JwtEncoderParameters
                .from(jwsHeader, createJwtClaimsSet(myUserDetails, now, refreshTokenValidity))).getTokenValue();
        return Pair.of(accessToken, refreshToken);
    }
}