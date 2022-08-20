package com.uxpsystems.assignment.service.impl;

import com.uxpsystems.assignment.dao.UserDao;
import com.uxpsystems.assignment.entity.Users;
import com.uxpsystems.assignment.config.UserNotFoundException;
import com.uxpsystems.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * BUSINESS LOGIC Service Class Implementation
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    List<Users> user = new ArrayList<>();

    /**
     * Testing purpose
     */
    public UserServiceImpl(){
        //user.add(new Users("Kislaya","12345", Users.Status.Activated));
    }

    @Override
    @Transactional
    public Users saveUser(Users users) {
        String username = users.getUsername();
        String password = users.getPassword();
        if(username.isEmpty()){
            throw new UserNotFoundException("Please Enter A Valid Username");
        }
        if(password.isEmpty()){
            throw new UserNotFoundException("Please Enter A Valid Password");
        }
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
    @Transactional
    public Users updateUser(long userId, Users users) {
        Users updateUsers = userDao.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        String username = users.getUsername();
        String password = users.getPassword();
        if(username.isEmpty()){
            throw new UserNotFoundException("Please Enter A Valid Username");
        }
        if(password.isEmpty()){
            throw new UserNotFoundException("Please Enter A Valid Password");
        }
        updateUsers.setUsername(users.getUsername());
        updateUsers.setPassword(users.getPassword());
        updateUsers.setStatus(users.getStatus());
        return userDao.save(updateUsers);
    }

    @Override
    @Transactional
    public void deleteUser(long userId) {
        Users users = userDao.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        userDao.delete(users);
    }
}
