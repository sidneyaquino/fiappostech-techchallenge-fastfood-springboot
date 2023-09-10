package com.fiappostech.fastfood.infrastructure.config.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapter.gateway.customer.CustomerFindByIdGateway;
import com.fiappostech.fastfood.adapter.gateway.customer.CustomerFindByIdRepositoryGateway;
import com.fiappostech.fastfood.adapter.gateway.customer.CustomerIdentifyGateway;
import com.fiappostech.fastfood.adapter.gateway.customer.CustomerIdentifyRepositoryGateway;
import com.fiappostech.fastfood.adapter.gateway.customer.CustomerRegistryGateway;
import com.fiappostech.fastfood.adapter.gateway.customer.CustomerRegistryRepositoryGateway;
import com.fiappostech.fastfood.infrastructure.persistence.customer.CustomerFindByIdRepository;
import com.fiappostech.fastfood.infrastructure.persistence.customer.CustomerFindByPersonalIdRepository;
import com.fiappostech.fastfood.infrastructure.persistence.customer.CustomerSaveRepository;

@Configuration
public class CustomerGatewayConfig {

   @Bean
   public CustomerFindByIdGateway customerFindByIdGateway(
         CustomerFindByIdRepository customerFindByIdRepository) {

      return new CustomerFindByIdRepositoryGateway(customerFindByIdRepository);
   }

   @Bean
   public CustomerIdentifyGateway customerIdentifyGateway(
         CustomerFindByPersonalIdRepository customerFindByPersonalIdRepository) {

   return new CustomerIdentifyRepositoryGateway(customerFindByPersonalIdRepository);
   }

   @Bean
   public CustomerRegistryGateway customerRegistryGateway(
         CustomerSaveRepository customerSaveRepository) {

   return new CustomerRegistryRepositoryGateway(customerSaveRepository);
   }
}