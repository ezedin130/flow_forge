package com.example.flow_forge.mapper;

import com.example.flow_forge.dto.permissionDto.PermissionInDto;
import com.example.flow_forge.dto.permissionDto.PermissionOutDto;
import com.example.flow_forge.model.Permission;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PermissionMapper {
    public Permission toEntity(PermissionInDto dto){
        return Permission.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public PermissionOutDto toDto(Permission permission){
        PermissionOutDto dto = new PermissionOutDto();
        dto.setId(permission.getId());
        dto.setName(permission.getName());
        dto.setDescription(permission.getDescription());
        dto.setCreatedAt(permission.getCreatedAt());
        return dto;
    }
}
