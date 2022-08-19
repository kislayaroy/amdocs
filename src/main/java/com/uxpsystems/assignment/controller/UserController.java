package com.uxpsystems.assignment.controller;

import com.uxpsystems.assignment.entity.Response;
import com.uxpsystems.assignment.entity.Users;
import com.uxpsystems.assignment.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST CONTROLLER for handling all the request
 */
@RestController
@RequestMapping("/users")
public class UserController {
    /**
     * Logger for better console output
     */
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * Testing
     * @return
     */
    @GetMapping("/hello")
    public String hello(){
        logger.trace("Test method called");
        return "Hello";
    }

    /**
     * POST MAPPING (creating user in DB)
     * @param users
     * @return
     */
    @PostMapping("/save")
    public Response saveUser(@RequestBody Users users){
        logger.trace("Save User method called");
        userService.saveUser(users);
        return new Response("User Inserted Successfully", Boolean.TRUE);
    }

    /**
     * GET MAPPING (fetching all users from DB)
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<List<Users>> getAllUser(){
        logger.trace("Get All User method called");
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * PUT MAPPING (updating user details )
     * @param users
     * @param userId
     * @return
     */
    @PutMapping("/update/{userId}")
    public ResponseEntity<Users> updateUser(@RequestBody Users users, @PathVariable long userId){
        logger.trace("Update User method called");
        return ResponseEntity.ok(userService.updateUser(userId, users));
    }

    /**
     * GET MAPPING (fetch user by user id)
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public ResponseEntity<Users> getById(@PathVariable long userId){
        logger.trace("Get By User Id method called");
        return ResponseEntity.ok(userService.findById(userId));
    }

    /**
     * DELETE MAPPING (delete user from DB)
     * @param userId
     * @return
     */
    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable long userId){
        logger.trace("Delete User method called");
        userService.deleteUser(userId);
        return "User Deleted Successfully";
    }
}
