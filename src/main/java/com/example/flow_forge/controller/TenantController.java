package com.example.flow_forge.controller;

import com.example.flow_forge.dto.tenantDto.TenantInDto;
import com.example.flow_forge.dto.tenantDto.TenantOutDto;
import com.example.flow_forge.mapper.TenantMapper;
import com.example.flow_forge.model.Tenant;
import com.example.flow_forge.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/tenant")
@Validated
@RequiredArgsConstructor
public class TenantController {
    @Autowired
    private final TenantService service;
    @Autowired
    private final TenantMapper mapper;
    @PostMapping("/create-tenant")
    public ResponseEntity<TenantOutDto> createTenant(@RequestBody TenantInDto dto) {
        TenantOutDto result = service.createTenant(dto);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/tenant")
    public ResponseEntity<List<TenantOutDto>> getAllTenants() {
        List<TenantOutDto> result = service.getAllTenants();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/tenant/{id}")
    public ResponseEntity<TenantOutDto> getUserById(@PathVariable Long id){
        Tenant tenant = service.findTenantById(id);
        TenantOutDto dto = mapper.toDto(tenant);
        return ResponseEntity.ok(dto);
    }

}
