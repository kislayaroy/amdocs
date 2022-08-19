package com.uxpsystems.assignment.service.impl;

import com.uxpsystems.assignment.dao.UserDao;
import com.uxpsystems.assignment.entity.Users;
import com.uxpsystems.assignment.config.UserNotFoundException;
import com.uxpsystems.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * BUSINESS LOGIC
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    List<Users> user = new ArrayList<>();

    public UserServiceImpl(){
        user.add(new Users("Kislaya","12345", Users.Status.Activated));
    }

    @Override
    public Users saveUser(Users users) {
        return userDao.save(users);
    }

    @Override
    public Users findById(long userId) {
        Users getById = userDao.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        return getById;
    }

    @Override
    public List<Users> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public Users updateUser(long userId, Users users) {
        Users updateUsers = userDao.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        updateUsers.setUsername(users.getUsername());
        updateUsers.setPassword(users.getPassword());
        updateUsers.setStatus(users.getStatus());
        return userDao.save(updateUsers);
    }

    @Override
    public void deleteUser(long userId) {
        Users users = userDao.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        userDao.delete(users);
    }
}
