package com.uxpsystems.assignment.service;

import com.uxpsystems.assignment.entity.Users;

import java.util.List;

/**
 * Service Class Interface
 */
public interface UserService {
    //For Saving The User
    Users saveUser(Users users);

    //Finding The User By User Id
    Users findById(long userId);

    //Get All The Users
    List<Users> getAllUsers();

    //Update The User Details
    Users updateUser(long userId, Users users);

    //Delete User By User Id
    void deleteUser(long userId);
}
