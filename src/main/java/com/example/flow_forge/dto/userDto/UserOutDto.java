package com.example.flow_forge.dto.userDto;

import com.example.flow_forge.model.Tenant;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class UserOutDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private Long tenant;
}
