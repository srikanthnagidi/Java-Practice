package com.example.restapi.demo.service;

import com.example.restapi.demo.entity.User;
import com.example.restapi.demo.exceptions.UserNotFoundException;
import com.example.restapi.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    @Autowired private UserRepository userRepository;

    public User getUser(Long id){
        Optional <User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }else{
            throw  new UserNotFoundException("User not found");
        }
    }

    public Iterable<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        User user1 = userRepository.save(user);
        Date date = new Date();
        user1.setCreatedAt(date);
        user1.setCreatedBy("admin");
        return user1;
    }


}
