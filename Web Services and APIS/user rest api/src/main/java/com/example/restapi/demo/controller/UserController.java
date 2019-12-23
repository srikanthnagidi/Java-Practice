package com.example.restapi.demo.controller;

import com.example.restapi.demo.DemoApplication;
import com.example.restapi.demo.entity.User;
import com.example.restapi.demo.repository.UserRepository;
import com.example.restapi.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
    @Autowired private UserService userService;

    @Autowired private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user = userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/users")
    public Iterable<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/users/create")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        log.info("Creating User {} ", user.getFirstName());
        if (user.getPassword().length()<7 || !user.getPassword().equals(
                user.getConfirmPassword())){
            log.error("Error with user password. Cannot create user {}", user.getFirstName());
            ResponseEntity.badRequest().build();
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setCreatedAt(new Date());
        user.setCreatedBy("admin");
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
