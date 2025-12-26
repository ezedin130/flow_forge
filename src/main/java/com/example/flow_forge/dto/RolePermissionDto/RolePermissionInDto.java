package com.example.flow_forge.dto.RolePermissionDto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class RolePermissionInDto {
    private Long role;
    private Long permission;
    private LocalDateTime createdAt;
    private Long tenant;
}
