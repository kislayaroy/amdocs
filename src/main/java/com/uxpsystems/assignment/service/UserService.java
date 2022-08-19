package com.uxpsystems.assignment.service;

import com.uxpsystems.assignment.entity.Users;

import java.util.List;

public interface UserService {

    Users saveUser(Users users);

    Users findById(long userId);

    List<Users> getAllUsers();

    Users updateUser(long userId, Users users);

    void deleteUser(long userId);
}
