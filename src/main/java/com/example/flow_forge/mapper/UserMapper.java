package com.example.flow_forge.mapper;

import com.example.flow_forge.dto.userDto.UserInDto;
import com.example.flow_forge.dto.userDto.UserOutDto;
import com.example.flow_forge.model.Tenant;
import com.example.flow_forge.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserMapper {
    public User toEntity(UserInDto dto, Tenant tenant){
        return User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .createdAt(LocalDateTime.now())
                .isActive(false)
                .tenant(tenant)
                .build();
    }
    public UserOutDto toDto(User user){
        UserOutDto dto = new UserOutDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setUserName(user.getUserName());
        dto.setPassword(user.getPassword());
        dto.setIsActive(user.getIsActive());
        dto.setTenant(user.getTenant().getId());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }
}
