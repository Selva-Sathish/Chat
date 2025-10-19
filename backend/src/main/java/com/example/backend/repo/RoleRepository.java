package com.example.backend.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);
    Role findById(int id);   
}
