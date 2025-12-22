package com.example.flow_forge.controller;

import com.example.flow_forge.dto.userDto.UserInDto;
import com.example.flow_forge.dto.userDto.UserOutDto;
import com.example.flow_forge.mapper.UserMapper;
import com.example.flow_forge.model.User;
import com.example.flow_forge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;
    @Autowired
    private final UserMapper userMapper;

    @PostMapping("/create-user")
    public ResponseEntity<UserOutDto> createUser(@RequestBody UserInDto dto){
        UserOutDto result = userService.createUser(dto);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserOutDto> getUserById(@PathVariable Long id){
        User user = userService.findUserById(id);
        UserOutDto dto = userMapper.toDto(user);
        return ResponseEntity.ok(dto);
    }
    @GetMapping()
    public ResponseEntity<List<UserOutDto>> getAllUsers(){
        List<UserOutDto> result = userService.findAllUsers();
        return ResponseEntity.ok(result);
    }
}
