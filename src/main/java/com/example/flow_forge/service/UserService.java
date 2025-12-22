package com.example.flow_forge.service;

import com.example.flow_forge.dto.userDto.UserInDto;
import com.example.flow_forge.dto.userDto.UserOutDto;
import com.example.flow_forge.mapper.UserMapper;
import com.example.flow_forge.model.Tenant;
import com.example.flow_forge.model.User;
import com.example.flow_forge.repository.TenantRepository;
import com.example.flow_forge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserMapper mapper;
    @Autowired
    private final TenantRepository tenantRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserOutDto createUser(UserInDto dto){
        Tenant tenant = tenantRepository.findById(dto.getTenantId())
                .orElseThrow(() -> new RuntimeException("Tenant not found"));
        User user = mapper.toEntity(dto,tenant);
        String username = generateUsername(dto.getFirstName(), dto.getLastName()).toLowerCase();
        user.setUserName(username);
        String password = dto.getFirstName() + "123";
        user.setPassword(encoder.encode(password));
        User savedUser = userRepository.save(user);
        return mapper.toDto(savedUser);
    }
    //todo : login method to be implemented once spring security is fully implemented
    public User findUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Store with " +id+" id is not found"));
    }
    public List<UserOutDto> findAllUsers(){
        return userRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    private String generateUsername(String firstName, String lastName) {
        return firstName.toLowerCase() + lastName.charAt(0);
    }
}
