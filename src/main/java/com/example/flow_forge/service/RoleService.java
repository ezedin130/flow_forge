package com.example.flow_forge.service;

import com.example.flow_forge.dto.roleDto.RoleInDto;
import com.example.flow_forge.dto.roleDto.RoleOutDto;
import com.example.flow_forge.mapper.RoleMapper;
import com.example.flow_forge.model.Role;
import com.example.flow_forge.model.Tenant;
import com.example.flow_forge.repository.RoleRepository;
import com.example.flow_forge.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {
    @Autowired
    private final RoleRepository roleRepository;
    @Autowired
    private final RoleMapper mapper;
    @Autowired
    private final TenantRepository tenantRepository;

    public RoleOutDto createRole(RoleInDto dto){
        Tenant tenant = tenantRepository.findById(dto.getTenantId())
                .orElseThrow(()-> new RuntimeException("Tenant not found"));
        Role role = mapper.toEntity(dto,tenant);
        Role savedRole = roleRepository.save(role);
        return mapper.toDto(savedRole);
    }
    public List<RoleOutDto> findAllRoles(){
        return roleRepository.findAll().stream()
                .map(mapper :: toDto)
                .collect(Collectors.toList());
    }
    public Role findRoleById(Long id){
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }

}
