package com.uxpsystems.assignment.config;

/**
 * USER NOT FOUND EXCEPTION
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(String.format(message));
    }
}
