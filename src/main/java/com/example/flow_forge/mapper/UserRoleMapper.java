package com.example.flow_forge.mapper;

import com.example.flow_forge.dto.user_roleDto.UserRoleInDto;
import com.example.flow_forge.dto.user_roleDto.UserRoleOutDto;
import com.example.flow_forge.model.Role;
import com.example.flow_forge.model.Tenant;
import com.example.flow_forge.model.User;
import com.example.flow_forge.model.UserRole;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserRoleMapper {
    public UserRole toEntity(UserRoleInDto dto, User user, Role role, Tenant tenant){
        return UserRole.builder()
                .createdAt(LocalDateTime.now())
                .user(user)
                .role(role)
                .tenant(tenant)
                .build();
    }
    public UserRoleOutDto toDto(UserRole userRole){
        UserRoleOutDto dto = new UserRoleOutDto();
        dto.setId(userRole.getId());
        dto.setCreatedAt(userRole.getCreatedAt());
        dto.setUser(userRole.getUser().getId());
        dto.setRole(userRole.getRole().getId());
        dto.setTenant(userRole.getTenant().getId());
        return dto;
    }
}
