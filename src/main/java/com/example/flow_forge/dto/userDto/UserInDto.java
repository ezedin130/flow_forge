package com.example.flow_forge.dto.userDto;

import lombok.Data;

import java.util.Set;

@Data
public class UserInDto {
    private String firstName;
    private String lastName;
    private String email;
    private Long tenantId;
    private Set<Long> roleIds;
}
