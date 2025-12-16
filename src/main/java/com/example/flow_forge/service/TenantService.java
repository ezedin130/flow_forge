package com.example.flow_forge.service;

import com.example.flow_forge.dto.tenantDto.TenantInDto;
import com.example.flow_forge.dto.tenantDto.TenantOutDto;
import com.example.flow_forge.mapper.TenantMapper;
import com.example.flow_forge.model.Tenant;
import com.example.flow_forge.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TenantService {
    private final TenantRepository tenantRepository;
    private final TenantMapper mapper;

    public TenantOutDto createTenant(TenantInDto dto){
        Tenant tenant = mapper.toEntity(dto);
        Tenant savedTenant = tenantRepository.save(tenant);
        return mapper.toDto(savedTenant);
    }
    public Tenant findTenantById(Long id){
        return tenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tenant not found"));
    }
    public List<TenantOutDto> getAllTenants(){
        return tenantRepository.findAll().stream()
                .map(mapper :: toDto)
                .collect(Collectors.toList());
    }
    //Todo: to be implemented to update the name , plan? and stripe_customer_id?
//    public TenantOutDto updateTenant(Long id,String name,Long plan,String stripe_customer_id String userName){
//    }
}
