package com.bpadilla.employee.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI employeeAppOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employees API")
                        .description("Documentación de API para gestión de empleados")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Erick Padilla")
                                .email("berick.padilla@icloud.com")));
    }
}
