package com.example.flow_forge.dto.user_roleDto;

import lombok.Data;

@Data
public class UserRoleInDto {
    private Long user;
    private Long role;
    private Long tenant;
}
