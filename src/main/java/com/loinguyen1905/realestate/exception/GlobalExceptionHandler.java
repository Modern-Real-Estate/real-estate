package com.loinguyen1905.realestate.exception;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<RestResponse<Object>> validationError(MethodArgumentNotValidException ex){
        BindingResult result = ex.getBindingResult();
        final List<FieldError> fieldError = result.getFieldErrors();
        List<String> error = fieldError.stream().map(e -> e.getDefaultMessage()).toList();
        RestResponse<Object> restResponse = RestResponse.builder().
            statusCode(HttpStatus.BAD_REQUEST.value()).
            error(ex.getBody().getDetail()).
            message(error.size() == 1 ? error.get(0) : error).
            build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(restResponse);
    }

    @ExceptionHandler(value = {
        UsernameNotFoundException.class,
        BadRequestException.class
    })
    public ResponseEntity<RestResponse<Object>> handldeException(BadRequestException ex) {
        RestResponse<Object> restResponse = RestResponse.builder().
            statusCode(HttpStatus.BAD_REQUEST.value()).
            message(ex.getStackTrace()).
            error(ex.getCause().getMessage()).build();
        return ResponseEntity.badRequest().body(restResponse);
    }
    
}