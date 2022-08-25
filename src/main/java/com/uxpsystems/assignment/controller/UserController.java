package com.uxpsystems.assignment.controller;

import com.uxpsystems.assignment.entity.Users;
import com.uxpsystems.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * REST CONTROLLER for handling all the request
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Testing
     * @return
     */
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    /**
     * POST MAPPING (creating user in DB)
     * @param users
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity<Users> saveUser(@Valid @RequestBody Users users){
        return new ResponseEntity<>(userService.saveUser(users), HttpStatus.CREATED);
    }

    /**
     * GET MAPPING (fetching all users from DB)
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<List<Users>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * PUT MAPPING (updating user details )
     * @param users
     * @param userId
     * @return
     */
    @PutMapping("/update/{userId}")
    public ResponseEntity<Users> updateUser(@Valid @RequestBody Users users,
                               @Valid @PathVariable long userId){
        return new ResponseEntity<>(userService.updateUser(userId, users), HttpStatus.OK
        );
    }

    /**
     * GET MAPPING (fetch user by user id)
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public ResponseEntity<Users> getById(@PathVariable long userId){
        return ResponseEntity.ok(userService.findById(userId));
    }

    /**
     * DELETE MAPPING (delete user from DB)
     * @param userId
     * @return
     */
    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable long userId){
        userService.deleteUser(userId);
        return "User Deleted Successfully with userId : "+userId;
    }
}
