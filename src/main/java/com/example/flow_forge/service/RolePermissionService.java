package com.example.flow_forge.service;

import com.example.flow_forge.dto.RolePermissionDto.RolePermissionInDto;
import com.example.flow_forge.dto.RolePermissionDto.RolePermissionOutDto;
import com.example.flow_forge.dto.user_roleDto.UserRoleInDto;
import com.example.flow_forge.dto.user_roleDto.UserRoleOutDto;
import com.example.flow_forge.mapper.RolePermissionMapper;
import com.example.flow_forge.mapper.UserRoleMapper;
import com.example.flow_forge.model.*;
import com.example.flow_forge.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolePermissionService {
    @Autowired
    private final RolePermissionRepository rolePermissionRepository;
    @Autowired
    private final PermissionRepository permissionRepository;
    @Autowired
    private final RoleRepository roleRepository;
    @Autowired
    private final TenantRepository tenantRepository;
    @Autowired
    private final RolePermissionMapper mapper;

    public RolePermissionOutDto createRolePermission(RolePermissionInDto dto) {
        Role role = roleRepository.findById(dto.getRole())
                .orElseThrow(() -> new RuntimeException("Role not found"));
        Permission permission = permissionRepository.findById(dto.getPermission())
                .orElseThrow(() -> new RuntimeException("permission not found"));
        Tenant tenant = tenantRepository.findById(dto.getTenant())
                .orElseThrow(() -> new RuntimeException("Tenant not found"));

        RolePermission result = mapper.toEntity(dto,permission,role,tenant);
        RolePermission savedUserRole = rolePermissionRepository.save(result);
        return mapper.toDto(savedUserRole);
    }
}
