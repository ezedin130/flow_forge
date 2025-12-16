package com.example.flow_forge.dto.tenantDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TenantOutDto {
    private Long id;
    private String name;
    //Todo: plan should be implemented after plan entity is implemented
    //    private Plan plan;
    private String tenantStatus;
    private LocalDateTime createdAt;
    //Todo: stripe customer id should be implemented in later stages of the project
    // private String stripe_customer_id;
}
