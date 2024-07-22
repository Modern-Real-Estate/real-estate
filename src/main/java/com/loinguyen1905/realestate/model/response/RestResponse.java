package com.loinguyen1905.realestate.model.response;

import lombok.*;

@Data
@Builder
public class RestResponse<T> {
    private int statusCode;
    private String error;
    private Object message;
    private T Data;
}