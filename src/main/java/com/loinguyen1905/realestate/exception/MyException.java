package com.loinguyen1905.realestate.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MyException extends Exception {
    private Integer statusCode;
    private String message;
    private Object error;
}