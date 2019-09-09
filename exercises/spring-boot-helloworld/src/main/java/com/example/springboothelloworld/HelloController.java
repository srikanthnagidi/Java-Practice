package com.example.springboothelloworld;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    private Map<String, Object> result = new HashMap<>();
    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, Object> hello(){
        result.put("name", "Srikanth");
        result.put("city", "DeKalb");

        return result;
    }
}
