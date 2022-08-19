package com.uxpsystems.assignment.dao;


import com.uxpsystems.assignment.entity.Users;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDaoTests {

    @Autowired
    private UserDao userDao;

    public void addUser(){
        Users users = new Users("Kislaya","12345", Users.Status.Activated);
    }

    @Test
    @Order(1)
    public void userByIdTest(){
        Users users = new Users("Kishu","12345", Users.Status.Activated);
        userDao.save(users);
        boolean actualResult = userDao.existsById((long) 1);
        assertThat(actualResult).isTrue();
    }

    @Test
    @Order(2)
    public void getAllUsers(){
        Users users = new Users("Kislaya","12345", Users.Status.Activated);
        userDao.save(users);
        List<Users> list = userDao.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    @Order(3)
    public void updateUser(){
        Users users = userDao.findById(1L).get();
        users.setStatus(Users.Status.Deactivated);
        userDao.save(users);
        assertNotEquals("Activate",userDao.findById(1L).get().getStatus());
    }

    @Test
    @Order(4)
    public void deleteUser(){
        userDao.deleteById(1L);
        assertThat(userDao.existsById(1L)).isFalse();
    }
}