package com.example.springbootthymeleaf.Controller;

import com.example.springbootthymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping("/demo")
    public String demo (Model model){
        model.addAttribute("message", "hello thymeleaf");
        double grade = 40;
        model.addAttribute("grade", grade);
        model.addAttribute("GPA", convertGPA(grade));

        return "demo";
    }

    @RequestMapping("/demo2")
    public String demo2(Model model){
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Tom", 32));
        userList.add(new User(2, "John", 24));
        userList.add(new User(3, "Mike", 36));
        model.addAttribute("list", userList);
        return "demo2";
    }
    @RequestMapping("demo3")
    public String demo3(HttpServletRequest request, Model model) {
        // Request
        request.setAttribute("request", "request data");
        // Session
        request.getSession().setAttribute("session", "session data");
        // Application
        request.getSession().getServletContext().setAttribute("application", "application data");
        return "demo2";
    }
    private String convertGPA(double grade) {
        if (grade>=90){
            return "A";
        }else if(grade<90 && grade>=80){
            return "B";
        }else if(grade<80 && grade>=70){
            return "C";
        }else if(grade<70 && grade>=60){
            return "D";
        }else{
            return "F";
        }
    }
}
