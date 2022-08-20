package com.uxpsystems.assignment.entity;

/**
 * TO Store the Response for new User
 */
public class Response {
    private long id;
    private String message;
    private boolean status;

    /**
     * CONSTRUCTORS
     */
    public Response() {
    }

    public Response(long id, String message, boolean status) {
        this.id = id;
        this.message = message;
        this.status = status;
    }

    /**
     * GETTER AND SETTERS
     * @return
     */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
