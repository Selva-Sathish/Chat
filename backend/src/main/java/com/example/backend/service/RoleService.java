package com.example.backend.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.backend.models.Role;
import com.example.backend.repo.RoleRepository;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository role){
        this.roleRepository = role;
    }


    public void createRole(String name){
        Role newrole = new Role();
        newrole.setName(name);
        roleRepository.save(newrole);
    }

    public Page<Role> getRoleByName(String name, Pageable pageable){
        return roleRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    public Page<Role> getAllRoles(Pageable pageable){
        return roleRepository.findAll(pageable);
    }


    public Role getRollById(Long id) {
        return roleRepository.findById(id).orElseThrow(()-> new RuntimeException("Role not Found"));
    }

}
