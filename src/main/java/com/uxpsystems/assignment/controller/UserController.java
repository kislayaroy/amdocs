package com.uxpsystems.assignment.controller;

import com.uxpsystems.assignment.entity.Response;
import com.uxpsystems.assignment.entity.Users;
import com.uxpsystems.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Response saveUser(@RequestBody Users users){
       return new Response("User Inserted Successfully", Boolean.TRUE);
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
    public ResponseEntity<Users> updateUser(@RequestBody Users users, @PathVariable long userId){
        return ResponseEntity.ok(userService.updateUser(userId, users));
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
        return "User Deleted Successfully";
    }
}
