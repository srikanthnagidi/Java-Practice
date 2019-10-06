package com.example.springbootwesocket.controller;

import com.example.springbootwesocket.model.User;
import com.example.springbootwesocket.model.UserResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.util.HtmlUtils;

public class UserController {

    @MessageMapping("/user")
    @SendTo("/topic/user")
    public UserResponse getUser(User user){
        return new UserResponse(HtmlUtils.htmlEscape("Hello "+user.getName()));
    }
}
