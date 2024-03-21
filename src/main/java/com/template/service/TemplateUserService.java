package com.template.service;

import com.template.entity.Role;
import com.template.entity.User;
import com.template.repository.RoleRepository;
import com.template.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class TemplateUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public String save(User user) {

        User save = userRepository.save(user);
        for (Role role : user.getRoles()) {
            role.setUser(save);
            roleRepository.save(role);
        }
        return save.getEmail()+" created Successfully...";
    }


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
