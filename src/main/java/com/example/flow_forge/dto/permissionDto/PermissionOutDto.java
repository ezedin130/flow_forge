package com.example.flow_forge.dto.permissionDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PermissionOutDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
}
