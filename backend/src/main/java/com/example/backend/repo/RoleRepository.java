package com.example.backend.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import com.example.backend.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);
    
    Page<Role> findByNameContainingIgnoreCase(String name, Pageable Pageable);
}
