package com.example.flow_forge.dto.roleDto;

import lombok.Data;

import java.util.Set;


@Data
public class RoleInDto {
    private String name;
    private String description;
    private Long tenantId;
}
