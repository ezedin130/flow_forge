package com.example.flow_forge.mapper;

import com.example.flow_forge.dto.roleDto.RoleInDto;
import com.example.flow_forge.dto.roleDto.RoleOutDto;
import com.example.flow_forge.model.Role;
import com.example.flow_forge.model.Tenant;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RoleMapper {
    public Role toEntity(RoleInDto dto, Tenant tenant){
        return Role.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .createdAt(LocalDateTime.now())
                .tenant(tenant)
                .build();
    }
    public RoleOutDto toDto(Role role){
        RoleOutDto dto = new RoleOutDto();
        dto.setId(role.getId());
        dto.setName(role.getName());
        dto.setDescription(role.getDescription());
        dto.setCreatedAt(role.getCreatedAt());
        dto.setTenant(role.getTenant().getId());
        return dto;
    }
}
