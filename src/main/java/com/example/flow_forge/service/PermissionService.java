package com.example.flow_forge.service;

import com.example.flow_forge.dto.permissionDto.PermissionInDto;
import com.example.flow_forge.dto.permissionDto.PermissionOutDto;
import com.example.flow_forge.mapper.PermissionMapper;
import com.example.flow_forge.model.Permission;
import com.example.flow_forge.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionService {
    @Autowired
    private final PermissionRepository permissionRepository;
    @Autowired
    private final PermissionMapper mapper;

    public PermissionOutDto createPermission(PermissionInDto dto){
        Permission permission = mapper.toEntity(dto);
        Permission savedPermission = permissionRepository.save(permission);
        return mapper.toDto(savedPermission);
    }
    public List<PermissionOutDto> findAllPermissions(){
        return permissionRepository.findAll().stream()
                .map(mapper :: toDto)
                .collect(Collectors.toList());
    }
    public Permission findPermissionById(Long id){
        return permissionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Permission Not Found!"));
    }
}
