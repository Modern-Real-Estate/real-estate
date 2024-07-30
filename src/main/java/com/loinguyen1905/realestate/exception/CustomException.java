package com.loinguyen1905.realestate.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private Integer statusCode;
    private String message;
    private Object error;

    public CustomException(String message) {
        this.message = message;
        this.statusCode = 400;
        this.error = "Exception occurs";
    }

    public CustomException(String message, Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.error = "Exception occurs";
    }
}