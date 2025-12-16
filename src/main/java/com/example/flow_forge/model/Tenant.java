package com.example.flow_forge.model;

import com.example.flow_forge.enums.TenantStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name of the tenant is required")
    private String name;
//    @NotNull(message = "plan is required")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Plan plan;
    @NotNull(message = "tenant status is required")
    @Enumerated(EnumType.STRING)
    private TenantStatus tenantStatus;
    @NotNull(message = "created at is required")
    private LocalDateTime createdAt;
    //Todo: stripe customer id should be implemented in later stages of the project
    //private String stripe_customer_id;
}
