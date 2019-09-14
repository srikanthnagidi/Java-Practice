package com.example.springbootthymeleaf.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("demo")
    public String demo (Model model){
        model.addAttribute("message", "hello thymeleaf");
        return "demo";
    }
}
