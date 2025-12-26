package com.example.flow_forge.mapper;

import com.example.flow_forge.dto.RolePermissionDto.RolePermissionInDto;
import com.example.flow_forge.dto.RolePermissionDto.RolePermissionOutDto;
import com.example.flow_forge.model.Permission;
import com.example.flow_forge.model.Role;
import com.example.flow_forge.model.RolePermission;
import com.example.flow_forge.model.Tenant;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RolePermissionMapper {
        public RolePermission toEntity(RolePermissionInDto dto, Permission permission, Role role, Tenant tenant){
            return RolePermission.builder()
                    .createdAt(LocalDateTime.now())
                    .role(role)
                    .permission(permission)
                    .tenant(tenant)
                    .build();
        }
        public RolePermissionOutDto toDto(RolePermission rolePermission){
            RolePermissionOutDto dto = new RolePermissionOutDto();
            dto.setId(rolePermission.getId());
            dto.setCreatedAt(rolePermission.getCreatedAt());
            dto.setRole(rolePermission.getRole().getId());
            dto.setPermission(rolePermission.getPermission().getId());
            dto.setTenant(rolePermission.getTenant().getId());
            return dto;
        }
    }
