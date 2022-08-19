package com.uxpsystems.assignment.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global Exception Handler for Any Exception Occur
 */
@RestControllerAdvice
public class GlobalException  {

    @ExceptionHandler(UserNotFoundException.class)
    public String UserNotFound(){
        return "User Not Found";
    }
}
