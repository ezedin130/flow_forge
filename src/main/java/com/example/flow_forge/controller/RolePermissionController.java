package com.example.flow_forge.controller;

import com.example.flow_forge.dto.RolePermissionDto.RolePermissionInDto;
import com.example.flow_forge.dto.RolePermissionDto.RolePermissionOutDto;
import com.example.flow_forge.dto.user_roleDto.UserRoleInDto;
import com.example.flow_forge.dto.user_roleDto.UserRoleOutDto;
import com.example.flow_forge.mapper.RolePermissionMapper;
import com.example.flow_forge.mapper.UserRoleMapper;
import com.example.flow_forge.service.RolePermissionService;
import com.example.flow_forge.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
public class RolePermissionController {
    @Autowired
    private final RolePermissionService rolePermissionService;
    @Autowired
    private final RolePermissionMapper mapper;

    @PostMapping("/create-role-permission")
    public ResponseEntity<RolePermissionOutDto> createUserRole(@RequestBody RolePermissionInDto dto){
        RolePermissionOutDto result = rolePermissionService.createRolePermission(dto);
        return ResponseEntity.ok(result);
    }
}
