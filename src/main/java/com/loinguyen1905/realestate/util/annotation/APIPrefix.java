package com.loinguyen1905.realestate.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1")
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface APIPrefix {
    String discription() default "";
}