package com.example.springbootexception.controller;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @RequestMapping("/add")
    public String add(){
        int num = 10/0;
        return "add";
    }
   /* @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView handlerArithmeticException(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e.toString());
        modelAndView.setViewName("mathError");
        return modelAndView;
    }
*/
    @RequestMapping("/update")
    public String update(){
        String name = null;
        name = name.toLowerCase();//this should cause nullpointer exceptions

        return "update";
    }
/*    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView handleNullPointerException(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e.toString());
        modelAndView.setViewName("nullPointerError");
        return modelAndView;
    }*/
}

