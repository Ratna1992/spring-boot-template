package com.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateResourceController {
    @GetMapping("/home")
    public String home(){
        return "Welcome Home";
    }

    @GetMapping("/user")
    public String user(){
        return "Welcome User";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Welcome Admin";
    }
}
