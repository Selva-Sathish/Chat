package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.backend.models.User;
import com.example.backend.repo.UserRepository;
import com.example.backend.security.CustomeUserDetails;

@Service
public class CustomeUserDetailsService implements UserDetailsService  {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        
        if(user == null) throw new UsernameNotFoundException("User Not Found " + username);

        return new CustomeUserDetails(user);
    }
    
}
