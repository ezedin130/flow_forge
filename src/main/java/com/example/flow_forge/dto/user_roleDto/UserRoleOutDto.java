package com.example.flow_forge.dto.user_roleDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserRoleOutDto {
    private Long id;
    private Long user;
    private Long role;
    private LocalDateTime createdAt;
    private Long tenant;
}
