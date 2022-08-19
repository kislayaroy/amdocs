package com.uxpsystems.assignment.entity;

/**
 * TO Store the Response for new User
 */
public class Response {

    private String message;
    private boolean status;

    public Response() {
    }

    public Response(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
