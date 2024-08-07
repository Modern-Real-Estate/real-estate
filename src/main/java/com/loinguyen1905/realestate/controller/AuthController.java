package com.loinguyen1905.realestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.realestate.common.SystemConstant;
import com.loinguyen1905.realestate.model.request.LoginRequest;
import com.loinguyen1905.realestate.model.request.RegisterRequest;
import com.loinguyen1905.realestate.model.response.AuthenResponse;
import com.loinguyen1905.realestate.service.IAuthService;
import com.loinguyen1905.realestate.service.IUserService;
import com.loinguyen1905.realestate.util.CookieUtils;
import com.loinguyen1905.realestate.util.SecurityUtils;
import com.loinguyen1905.realestate.util.annotation.MetaMessage;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("${release.api.prefix}/auth")
public class AuthController {
    @Autowired
    private IAuthService authService;

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtDecoder jwtDecoder;

    @Autowired
    private CookieUtils cookieUtils;

    @PostMapping("/login")
    @MetaMessage(message = "Login success")
    public ResponseEntity<AuthenResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        AuthenResponse authenResponse = this.authService.handleLogin(loginRequest);
        return ResponseEntity.ok()
            .header(HttpHeaders.SET_COOKIE, this.cookieUtils.createCookie(SystemConstant.REFRESH_TOKEN, authenResponse.getRefreshToken()).toString())
            .body(authenResponse);
    }

    @PostMapping("/register")
    @MetaMessage(message = "Register success")
    public ResponseEntity<AuthenResponse> register(@Valid @RequestBody RegisterRequest registerRequest) { 
        AuthenResponse authenResponse = this.authService.handleRegister(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(authenResponse);
    }

    @GetMapping("/refresh")
    @MetaMessage(message = "Get user by refresh token success")
    public ResponseEntity<AuthenResponse> getAuthenticationResultByRefreshToken(
        @CookieValue(name = "refresh_token", defaultValue = "Not found any refresh token") String refreshToken
    ) {
        Jwt jwt = this.jwtDecoder.decode(refreshToken);
        AuthenResponse authenResponse = this.authService.handleGetAuthenResponseByUsernameAndRefreshToken(jwt.getSubject(), refreshToken);
        return ResponseEntity.ok()
            .header(HttpHeaders.SET_COOKIE, this.cookieUtils.createCookie(SystemConstant.REFRESH_TOKEN, authenResponse.getRefreshToken()).toString())
            .body(authenResponse);
    }

    @GetMapping("/account")
    @MetaMessage(message = "Get my account success")
    public ResponseEntity<AuthenResponse> getAccount() {
        String username = SecurityUtils.getCurrentUserLogin()
            .orElseThrow(() -> new UsernameNotFoundException("Not found username"));
        AuthenResponse authenResponse = AuthenResponse.builder().userDTO(this.userService.handleGetUserByUsername(username)).build();
        return ResponseEntity.ok().body(authenResponse);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        String username = SecurityUtils.getCurrentUserLogin().orElseThrow(() -> new UsernameNotFoundException("Not found username"));
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .header(HttpHeaders.SET_COOKIE, this.cookieUtils.deleteCookie(SystemConstant.REFRESH_TOKEN).toString())
            .body(this.authService.handleLogout(username));
    }
}