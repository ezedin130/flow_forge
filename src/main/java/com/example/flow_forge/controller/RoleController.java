package com.example.flow_forge.controller;

import com.example.flow_forge.dto.roleDto.RoleInDto;
import com.example.flow_forge.dto.roleDto.RoleOutDto;
import com.example.flow_forge.mapper.RoleMapper;
import com.example.flow_forge.model.Role;
import com.example.flow_forge.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Validated
@RequiredArgsConstructor
public class RoleController {
    @Autowired
    private final RoleService  roleService;
    @Autowired
    private final RoleMapper mapper;

    @PostMapping("/create-role")
    public ResponseEntity<RoleOutDto> createRole(@RequestBody RoleInDto dto){
        RoleOutDto result = roleService.createRole(dto);
        return ResponseEntity.ok(result);
    }
    @GetMapping()
    public ResponseEntity<List<RoleOutDto>> findAll(){
        List<RoleOutDto> result = roleService.findAllRoles();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RoleOutDto> findRoleById(@PathVariable Long id){
        Role role = roleService.findRoleById(id);
        RoleOutDto result = mapper.toDto(role);
        return ResponseEntity.ok(result);
    }
}
