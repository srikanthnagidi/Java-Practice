package com.example.springbootfileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {
    Map<String, Object> result = new HashMap<>();
    //Receive Message
    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, Object> upload(@RequestParam("attach")MultipartFile file) throws IOException{
        System.out.println("file name = " + file.getOriginalFilename());
        System.out.println("file type = " + file.getContentType());
        //save to disk
        // file path example
        String filePath = "C:\\Users\\srika\\OneDrive\\Documents\\";
        filePath = filePath.replace("\\", "/");
        file.transferTo(new File(filePath + file.getOriginalFilename()));
        result.put("Success", true);
        return result;
    }
}
