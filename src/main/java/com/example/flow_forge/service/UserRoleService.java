package com.example.flow_forge.service;

import com.example.flow_forge.dto.user_roleDto.UserRoleInDto;
import com.example.flow_forge.dto.user_roleDto.UserRoleOutDto;
import com.example.flow_forge.mapper.UserRoleMapper;
import com.example.flow_forge.model.Role;
import com.example.flow_forge.model.Tenant;
import com.example.flow_forge.model.User;
import com.example.flow_forge.model.UserRole;
import com.example.flow_forge.repository.RoleRepository;
import com.example.flow_forge.repository.TenantRepository;
import com.example.flow_forge.repository.UserRepository;
import com.example.flow_forge.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleService {
    @Autowired
    private final UserRoleRepository userRoleRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final RoleRepository roleRepository;
    @Autowired
    private final TenantRepository tenantRepository;
    @Autowired
    private final UserRoleMapper mapper;

    public UserRoleOutDto createUserRole(UserRoleInDto dto) {
        User user = userRepository.findById(dto.getUser())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Role role = roleRepository.findById(dto.getRole())
                .orElseThrow(() -> new RuntimeException("Role not found"));
        Tenant tenant = tenantRepository.findById(dto.getTenant())
                .orElseThrow(() -> new RuntimeException("Tenant not found"));

        UserRole result = mapper.toEntity(dto,user,role,tenant);
        UserRole savedUserRole = userRoleRepository.save(result);
        return mapper.toDto(savedUserRole);
    }
}