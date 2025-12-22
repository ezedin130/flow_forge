package com.example.flow_forge.dto.roleDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RoleOutDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private Long tenant;
}
