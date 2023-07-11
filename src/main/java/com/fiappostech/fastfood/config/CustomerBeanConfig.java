package com.fiappostech.fastfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapters.outbound.CustomerFindByIdRepository;
import com.fiappostech.fastfood.adapters.outbound.CustomerFindByPersonalIdRepository;
import com.fiappostech.fastfood.adapters.outbound.CustomerSaveRepository;
import com.fiappostech.fastfood.application.core.CustomerFindByIdService;
import com.fiappostech.fastfood.application.core.CustomerIdentifyService;
import com.fiappostech.fastfood.application.core.CustomerRegistryService;

@Configuration
public class CustomerBeanConfig {

   @Bean
   public CustomerRegistryService customerRegistryService(
         CustomerSaveRepository customerSaveRepository) {

      return new CustomerRegistryService(customerSaveRepository);
   }

   @Bean
   public CustomerFindByIdService customerFindByIdService(
         CustomerFindByIdRepository customerFindByIdRepository) {

      return new CustomerFindByIdService(customerFindByIdRepository);
   }

   @Bean
   public CustomerIdentifyService customerIdentifyService(
         CustomerFindByPersonalIdRepository customerFindByPersonalIdRepository) {

      return new CustomerIdentifyService(customerFindByPersonalIdRepository);
   }
}