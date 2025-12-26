package com.example.flow_forge.dto.RolePermissionDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RolePermissionOutDto {
    private Long id;
    private Long role;
    private Long permission;
    private LocalDateTime createdAt;
    private Long tenant;
}
