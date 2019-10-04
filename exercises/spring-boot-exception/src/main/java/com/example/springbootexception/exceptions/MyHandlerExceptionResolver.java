package com.example.springbootexception.exceptions;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Nullable Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();

        if (e instanceof ArithmeticException){
            modelAndView.setViewName("mathError");
        }
        if (e instanceof NullPointerException){
            modelAndView.setViewName("nullPointerError");
        }
        modelAndView.addObject("exception", e.toString());
        return modelAndView;
    }
}
