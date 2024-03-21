package com.template.controller;

import com.template.entity.Role;
import com.template.entity.User;
import com.template.service.TemplateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/template")
public class TemplateUserController {

    @Autowired
    private TemplateUserService templateUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/users")
    public String save(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return templateUserService.save(user);
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return templateUserService.findAllUsers();
    }
}
