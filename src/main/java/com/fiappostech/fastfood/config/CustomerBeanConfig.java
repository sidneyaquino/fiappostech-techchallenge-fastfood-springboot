package com.fiappostech.fastfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapters.outbound.CustomerSaveServiceAdapter;
import com.fiappostech.fastfood.adapters.outbound.CustomerFindByIdServiceAdapter;
import com.fiappostech.fastfood.application.core.CustomerIdentifyUseCase;
import com.fiappostech.fastfood.application.core.CustomerRegistryUseCase;

@Configuration
public class CustomerBeanConfig {

   @Bean
   public CustomerRegistryUseCase customerRegistryUseCase(CustomerSaveServiceAdapter customerInsertServiceAdapter) {
      return new CustomerRegistryUseCase(customerInsertServiceAdapter);
   }

   @Bean
   public CustomerIdentifyUseCase customerIdentifyUseCase(CustomerFindByIdServiceAdapter customerFindByIdServiceAdapter) {
      return new CustomerIdentifyUseCase(customerFindByIdServiceAdapter);
   }
}