package com.fiappostech.fastfood.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

   @Bean
   public OpenAPI customOpenAPI() {
      return new OpenAPI()
            .info(new Info()
                  .title("Fiap-Postech Fastfood API Application")
                  .description(
                        "API Rest of Fiap-Postech's Fastfood application, including customers and products CRUD functionalities, as well as orders, checkout and payment.")
                  .summary("The Fastfood Open API")
                  .version("0.4.2")
                  .contact(new Contact()
                        .name("Sidney Aquino")
                        .url("https://www.linkedin.com/in/sidneydeaquino/"))
                  .license(new License()
                        .name("MIT License")
                        .url("https://github.com/sidneyaquino/fiappostech-techchallenge-fastfood-springboot/")));
   }
}