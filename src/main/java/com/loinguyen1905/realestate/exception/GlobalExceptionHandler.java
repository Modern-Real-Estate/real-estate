package com.loinguyen1905.realestate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.loinguyen1905.realestate.model.response.RestResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<RestResponse> handldeException(Exception ex) {
        RestResponse restResponse = RestResponse.builder().
            statusCode(HttpStatus.BAD_REQUEST.value()).
            message(ex.getMessage()).
            error(ex.getMessage()).build();
        return ResponseEntity.badRequest().body(restResponse);
    }
}