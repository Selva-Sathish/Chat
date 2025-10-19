package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.ApiRespone;
import com.example.backend.models.Role;
import com.example.backend.service.RoleService;

@RestController 
class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleServices){
        this.roleService = roleServices;
    }

    @GetMapping("roles")
    public ResponseEntity<ApiRespone<Page<Role>>> listRoles(
        @RequestParam(defaultValue="0") int page,
        @RequestParam(defaultValue="10") int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        Page<Role> data = roleService.getAllRoles(pageable);
        ApiRespone<Page<Role>> response = new ApiRespone<>(true, data, null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("roles/{id}")
    public ResponseEntity<ApiRespone<Role>> getRole(@PathVariable int id){
        Role data = roleService.getRollById(id);
        if(data == null) return ResponseEntity.ok(new ApiRespone<>(false, null, "Roles Not Found"));
        ApiRespone<Role> response = new ApiRespone<>(true, data, "Roles fetched successfully...");
        return ResponseEntity.ok(response);
    }

}
