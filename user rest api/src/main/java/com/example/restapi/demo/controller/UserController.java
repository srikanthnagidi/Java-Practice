package com.example.restapi.demo.controller;

import com.example.restapi.demo.entity.User;
import com.example.restapi.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired private UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user = userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/users")
    public Iterable<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        User user1 = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

}
