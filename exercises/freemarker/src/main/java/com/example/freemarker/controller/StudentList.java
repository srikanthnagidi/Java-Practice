package com.example.freemarker.controller;

import com.example.freemarker.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentList {
    @RequestMapping("/list")
    @ResponseBody
    public String list(Model model){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Tom", 3.5));
        list.add(new Student(2, "Jerry", 3.8));
        list.add(new Student(3, "Mike", 3.2));
        model.addAttribute("list", list);
        return "list";
    }
}
