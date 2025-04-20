package com.rojonovick.companies_crud.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info= @Info(
                title= "companies crud",
                version="1.0.0",
                description="This is a CRUD for management companies"
        )
)
public class OpenApiConfig {
}
