package com.uxpsystems.assignment.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Global Exception Handler for Any Exception Occur
 */
@RestControllerAdvice
public class GlobalException  {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String, String> exceptionHashMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->
                exceptionHashMap.put(error.getField(),error.getDefaultMessage()));
        return exceptionHashMap;
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String,String> userNotFound(UserNotFoundException ex){
        Map<String, String> exceptionHashMap = new HashMap<>();
        exceptionHashMap.put("Error", ex.getMessage());
        return exceptionHashMap;
    }
}
