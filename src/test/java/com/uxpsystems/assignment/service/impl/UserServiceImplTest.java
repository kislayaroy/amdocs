package com.uxpsystems.assignment.service.impl;

import com.uxpsystems.assignment.dao.UserDao;
import com.uxpsystems.assignment.entity.Users;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceImplTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void saveUserTest() {
        Users user = new Users("Kislaya","12345", Users.Status.Activated);
        when(userDao.save(user)).thenReturn(user);
        assertEquals(user,userService.saveUser(user));
    }

    @Test
    public void getAllUsersTest() {
        Users user1 = new Users("Ram","12345", Users.Status.Activated);
        Users user2 = new Users("Raju","12345", Users.Status.Activated);
        List<Users> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        when(userDao.findAll()).thenReturn(list);
        assertEquals(2,userService.getAllUsers().size());
    }

    @Test
    public void findByIdTest(){
        Optional<Users> user = Optional.ofNullable(new Users("Amdocs","12345", Users.Status.Activated));
        when(userDao.findById(1L)).thenReturn(user);
        assertEquals(0, userService.findById(1L).getUserId());
    }
    /*
    @Test
    public void deleteTest(){
        Users user = new Users("Kislaya","12345","Activated");
        userService.deleteUser(user.getUserId());
        verify(userDao,times(1)).deleteById(user.getUserId());
    }*/
}