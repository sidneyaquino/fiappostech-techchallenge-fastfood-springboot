package com.fiappostech.fastfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapters.outbound.CustomerInsertServiceAdapter;
import com.fiappostech.fastfood.adapters.outbound.CustomerSelectServiceAdapter;
import com.fiappostech.fastfood.application.core.CustomerIdentifyUseCase;
import com.fiappostech.fastfood.application.core.CustomerRegistryUseCase;

@Configuration
public class CustomerBeanConfig {

   @Bean
   public CustomerRegistryUseCase customerRegistryUseCase(CustomerInsertServiceAdapter customerInsertServiceAdapter) {
      return new CustomerRegistryUseCase(customerInsertServiceAdapter);
   }

   @Bean
   public CustomerIdentifyUseCase customerIdentifyUseCase(CustomerSelectServiceAdapter customerSelectServiceAdapter) {
      return new CustomerIdentifyUseCase(customerSelectServiceAdapter);
   }
}