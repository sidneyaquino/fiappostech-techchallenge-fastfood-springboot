package com.fiappostech.fastfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapters.outbound.CustomerCreateServiceAdapter;
import com.fiappostech.fastfood.adapters.outbound.CustomerIdentifyServiceAdapter;
import com.fiappostech.fastfood.application.core.usecase.CustomerCreateUseCase;
import com.fiappostech.fastfood.application.core.usecase.CustomerIdentifyUseCase;

@Configuration
public class CustomerBeanConfig {

   @Bean
   public CustomerCreateUseCase createCustomerUseCase(CustomerCreateServiceAdapter customerCreateAdapter) {
      return new CustomerCreateUseCase(customerCreateAdapter);
   }

   @Bean
   public CustomerIdentifyUseCase identificarClienteService(CustomerIdentifyServiceAdapter customerIdentifyAdapter) {
      return new CustomerIdentifyUseCase(customerIdentifyAdapter);
   }
}