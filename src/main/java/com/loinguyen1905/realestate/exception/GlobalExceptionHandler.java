package com.loinguyen1905.realestate.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.naming.AuthenticationException;

import org.apache.coyote.BadRequestException;
import org.hibernate.NonUniqueResultException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.loinguyen1905.realestate.model.response.RestResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<RestResponse<Object>> validationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        final List<FieldError> fieldError = result.getFieldErrors();
        List<String> error = fieldError.stream().map(e -> e.getDefaultMessage()).toList();
        RestResponse<Object> restResponse = RestResponse
            .builder()
            .statusCode(HttpStatus.BAD_REQUEST.value())
            .error(ex.getBody().getDetail())
            .message(error.size() == 1 ? error.get(0) : error)
            .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(restResponse);
    }

    // @ExceptionHandler({ AuthenticationException.class })
    // public ResponseEntity<RestResponse<Object>> handleAuthenticationException(AuthenticationException ex) {

    //     RestResponse<Object> re = RestResponse
    //         .builder()
    //         .statusCode(HttpStatus.UNAUTHORIZED.value())
    //         .error("Authentication failed at controller advice")
    //         .message(ex.getMessage())
    //         .build();
            
    //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(re);
    // }

    @ExceptionHandler(value = {
        UsernameNotFoundException.class,
        BadRequestException.class,
        BadCredentialsException.class
    })
    public ResponseEntity<RestResponse<Object>> handleBadRequestEx(Exception ex) {
        RestResponse<Object> restResponse = RestResponse
            .builder()
            .statusCode(HttpStatus.BAD_REQUEST.value())
            .message("Exception occurs please check your information")
            .error(ex.getMessage()).build();
        return ResponseEntity.badRequest().body(restResponse);
    }

    @ExceptionHandler(value = {
        DataIntegrityViolationException.class,
        NonUniqueResultException.class,
        SQLIntegrityConstraintViolationException.class,
        InvalidDataAccessResourceUsageException.class
    })
    public ResponseEntity<RestResponse<Object>> handleJpaDataConstraint(Exception ex) {
        RestResponse<Object> restResponse = RestResponse
            .builder()
            .statusCode(HttpStatus.BAD_REQUEST.value())
            .message("Data constraint in your resquest invalid or non-unique")
            .error("Email or username was used").build();
        return ResponseEntity.badRequest().body(restResponse);
    }
    
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<RestResponse<Object>> handldeException(Exception ex) {
        RestResponse<Object> restResponse = RestResponse
            .builder()
            .statusCode(HttpStatus.BAD_REQUEST.value())
            .message("Exception occurs")
            .error(ex.getMessage()).build();
        return ResponseEntity.badRequest().body(restResponse);
    }
}