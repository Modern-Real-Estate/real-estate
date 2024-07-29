package com.loinguyen1905.realestate.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.*;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component("handlerInterceptor")
public class BasicAuthInterceptor implements HandlerInterceptor {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    @Override
    public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // String authHeader = request.getHeader("Authorization");
        // if (authHeader != null && authHeader.startsWith("Basic ")) {

        //     String base64Credentials = authHeader.substring("Basic ".length());
        //     byte[] decodedCredentials = Base64.getDecoder().decode(base64Credentials);
        //     String credentials = new String(decodedCredentials, StandardCharsets.UTF_8);

        //     String[] parts = credentials.split(":");
        //     String username = parts[0];
        //     String password = parts[1];

        //     if (USERNAME.equals(username) && PASSWORD.equals(password)) {
        //         return true;
        //     }
        // }
        // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}