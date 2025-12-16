package com.example.flow_forge.mapper;

import com.example.flow_forge.dto.tenantDto.TenantInDto;
import com.example.flow_forge.dto.tenantDto.TenantOutDto;
import com.example.flow_forge.enums.TenantStatus;
import com.example.flow_forge.model.Tenant;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class TenantMapper {
    public Tenant toEntity(TenantInDto dto) {
        return Tenant.builder()
                .name(dto.getName())
                .tenantStatus(TenantStatus.INACTIVE)
                .createdAt(LocalDateTime.now())
                .build();
    }
    public TenantOutDto toDto(Tenant tenant){
        TenantOutDto dto = new TenantOutDto();
        dto.setId(tenant.getId());
        dto.setName(tenant.getName());
        dto.setTenantStatus(tenant.getTenantStatus().name());
        dto.setCreatedAt(tenant.getCreatedAt());
        return dto;
    }
}
