package com.loinguyen1905.realestate.service;

import com.loinguyen1905.realestate.model.request.LoginRequest;
import com.loinguyen1905.realestate.model.request.RegisterRequest;
import com.loinguyen1905.realestate.model.response.AuthenResponse;

public interface IAuthService {
    public AuthenResponse handleLogin(LoginRequest loginRequest);
    public AuthenResponse handleRegister(RegisterRequest registerRequest);
    public AuthenResponse handleGetAuthenResponseByUsernameAndRefreshToken(String username, String refreshToken);
    public Void handleUpdateUsersRefreshToken(String username, String refreshToken);
    public Void handleLogout(String username);
}