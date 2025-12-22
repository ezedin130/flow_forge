package com.example.flow_forge.mapper;

import com.example.flow_forge.dto.userDto.UserInDto;
import com.example.flow_forge.dto.userDto.UserOutDto;
import com.example.flow_forge.model.Role;
import com.example.flow_forge.model.Tenant;
import com.example.flow_forge.model.User;
import com.example.flow_forge.repository.RoleRepository;
import com.example.flow_forge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserMapper {
    @Autowired
    private final RoleRepository roleRepository;
    public User toEntity(UserInDto dto, Tenant tenant){
        Set<Role> roles = new HashSet<>();
        if (dto.getRoleIds() != null) {
            roles = dto.getRoleIds().stream()
                    .map(id -> roleRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Role with ID " + id + " not found")))
                    .collect(Collectors.toSet());
        }
        return User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .createdAt(LocalDateTime.now())
                .isActive(false)
                .tenant(tenant)
                .roles(roles)
                .build();
    }
    public UserOutDto toDto(User user){
        Set<Long> roleIds = new HashSet<>(user.getRoles()).stream()
                .map(Role::getId)
                .collect(Collectors.toSet());
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
        dto.setRoleIds(roleIds);
        return dto;
    }
}
