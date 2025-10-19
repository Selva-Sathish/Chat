package com.example.backend.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.backend.models.Role;
import com.example.backend.models.User;
import com.example.backend.repo.RoleRepository;
import com.example.backend.repo.UserRepository;

@Component
public class Setup implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public Setup(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        roleRepository.save(role);
        
        User user = new User();
        user.setUsername("sathish");
        user.setPassword(passwordEncoder.encode("sathish"));
        user.setRoles(Set.of(role));
        userRepository.save(user);
    }
    
}
