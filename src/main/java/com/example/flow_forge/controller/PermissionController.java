package com.example.flow_forge.controller;

import com.example.flow_forge.dto.permissionDto.PermissionInDto;
import com.example.flow_forge.dto.permissionDto.PermissionOutDto;
import com.example.flow_forge.mapper.PermissionMapper;
import com.example.flow_forge.model.Permission;
import com.example.flow_forge.repository.PermissionRepository;
import com.example.flow_forge.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
@Validated
@RequiredArgsConstructor
public class PermissionController {
    @Autowired
    private final PermissionService service;
    @Autowired
    private final PermissionMapper mapper;

    @PostMapping("/create-permission")
    public ResponseEntity<PermissionOutDto> createPermission(@RequestBody PermissionInDto dto){
        PermissionOutDto result = service.createPermission(dto);
        return ResponseEntity.ok().body(result);
    }
    @GetMapping()
    public ResponseEntity<List<PermissionOutDto>> getAllPermission(){
        List<PermissionOutDto> result = service.findAllPermissions();
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PermissionOutDto> getPermissionById(@PathVariable Long id){
        Permission permission = service.findPermissionById(id);
        PermissionOutDto dto = mapper.toDto(permission);
        return ResponseEntity.ok().body(dto);
    }
}
