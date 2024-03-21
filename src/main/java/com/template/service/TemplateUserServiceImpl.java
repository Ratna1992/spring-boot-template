package com.template.service;

import com.template.entity.Role;
import com.template.entity.User;
import com.template.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class TemplateUserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String logonId) throws UsernameNotFoundException {
        User user = userRepository.findBylogonId(logonId).orElseThrow(() -> new UsernameNotFoundException("logonId doesn't exist " + logonId));
        return new org.springframework.security.core.userdetails.User(user.getLogonId(), user.getPassword(), getAuthorities(user.getRoles()));

    }

    private Set<GrantedAuthority> getAuthorities(Set<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleDescription())).collect(Collectors.toSet());
    }
}
