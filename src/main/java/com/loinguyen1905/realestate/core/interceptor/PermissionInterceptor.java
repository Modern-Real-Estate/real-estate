package com.loinguyen1905.realestate.core.interceptor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.loinguyen1905.realestate.exception.CustomRuntimeException;
import com.loinguyen1905.realestate.model.dto.PermissionDTO;
import com.loinguyen1905.realestate.util.SecurityUtils;
import com.loinguyen1905.realestate.util.StringToPermissionUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String 
            path = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE),
            requestURI = request.getRequestURI(),
            httpMethod = request.getMethod();
        if(SecurityUtils.getCurrentUsersPermissions().isPresent()) {
            List<PermissionDTO> permissionDTOs = SecurityUtils.getCurrentUsersPermissions().get()
                .stream().map(item -> StringToPermissionUtils.toPermission(item)).toList();
            Boolean isAllow = permissionDTOs.stream().anyMatch(item -> (item.getApiPath().equals(path) && item.getMethod().equals(httpMethod)) || item.getApiPath().equals("/api/v1/"));
            if(isAllow == false) throw new CustomRuntimeException("Cannot use endpoint " + path, 403, "Fornidden");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Post-request logic
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Cleanup logic after request completion
    }
}