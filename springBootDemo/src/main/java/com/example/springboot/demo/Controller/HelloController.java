package com.example.springboot.demo.Controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@ResponseBody
public class HelloController {
    @RequestMapping("/hello")
    private String index(){
        return "Hello World!";
    }
}
