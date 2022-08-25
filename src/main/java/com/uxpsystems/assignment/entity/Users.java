package com.uxpsystems.assignment.entity;


import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * MODEL class for the USER
 */
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Users {
    /**
     * primary key for User
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long userId;
    @Column(name = "username", unique = true)
    @NotBlank(message = "User name must be unique")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "status")
    private Status status;

    /**
     * Enum class for the status of the User
     */
    public enum Status{
        Activated,
        Deactivated
    }

    /**
     * CONSTRUCTORS
     */
    public Users() {
        super();
    }

    public Users(String username, String password, Status status) {
        super();
        this.username = username;
        this.password = password;
        this.status = status;
    }

    /**
     * GETTERS AND SETTERS
     * @return
     */
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
            this.status = status;
    }
}