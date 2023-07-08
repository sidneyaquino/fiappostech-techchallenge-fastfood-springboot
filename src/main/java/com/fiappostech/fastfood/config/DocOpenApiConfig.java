package com.fiappostech.fastfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class DocOpenApiConfig {

   @Bean
   public OpenAPI customOpenAPI() {
      return new OpenAPI()
            .info(new Info()
                  .title("Fiap-Postech Fastfood API")
                  .description(
                        "API Rest of Fiap-Postech's Fastfood application, including customers and products CRUD functionalities, as well as orders and payment.")
                  .version("0.9")
                  .contact(new Contact()
                        .name("Sidney Aquino")
                        .email("sidneyaquino@outlook.de"))
                  .license(new License()
                        .name("MIT License")
                        .url("https://github.com/sidneyaquino/fiappostech-techchallenge-fastfood-springboot/blob/main/LICENSE")));
   }
}