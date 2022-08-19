package com.uxpsystems.assignment.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException  {

    @ExceptionHandler(UserNotFoundException.class)
    public String UserNotFound(){
        return "User Not Found";
    }
}
