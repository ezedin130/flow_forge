package com.example.flow_forge.dto.tenantDto;
import lombok.Data;


@Data
public class TenantInDto {
    private String name;
    //Todo: plan should be implemented after plan entity is implemented
    //    private Plan plan;
    //Todo: stripe customer id should be implemented in later stages of the project
    // private String stripe_customer_id;
}
