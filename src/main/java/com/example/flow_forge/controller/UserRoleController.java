package com.example.flow_forge.controller;

import com.example.flow_forge.dto.user_roleDto.UserRoleInDto;
import com.example.flow_forge.dto.user_roleDto.UserRoleOutDto;
import com.example.flow_forge.mapper.UserRoleMapper;
import com.example.flow_forge.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
public class UserRoleController {
    private final UserRoleService userRoleService;
    private final UserRoleMapper mapper;

    @PostMapping("/create-user-role")
    public ResponseEntity<UserRoleOutDto> createUserRole(@RequestBody UserRoleInDto dto){
        UserRoleOutDto result = userRoleService.createUserRole(dto);
        return ResponseEntity.ok(result);
    }
}
