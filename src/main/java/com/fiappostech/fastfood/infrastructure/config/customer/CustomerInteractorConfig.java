package com.fiappostech.fastfood.infrastructure.config.customer;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapter.gateway.customer.CustomerFindByIdGateway;
import com.fiappostech.fastfood.adapter.gateway.customer.CustomerIdentifyGateway;
import com.fiappostech.fastfood.adapter.gateway.customer.CustomerRegistryGateway;
import com.fiappostech.fastfood.application.usecase.customer.CustomerFindByIdInteractor;
import com.fiappostech.fastfood.application.usecase.customer.CustomerFindByIdUseCase;
import com.fiappostech.fastfood.application.usecase.customer.CustomerIdentifyInteractor;
import com.fiappostech.fastfood.application.usecase.customer.CustomerIdentifyUseCase;
import com.fiappostech.fastfood.application.usecase.customer.CustomerRegistryInteractor;
import com.fiappostech.fastfood.application.usecase.customer.CustomerRegistryUseCase;
import com.fiappostech.fastfood.application.usecase.customer.validator.CustomerRegistryExistsValidator;
import com.fiappostech.fastfood.application.usecase.customer.validator.CustomerRegistryValidator;

@Configuration
public class CustomerInteractorConfig {

   @Bean
   public CustomerFindByIdUseCase customerFindByIdUseCase(
         CustomerFindByIdGateway customerFindByIdGateway) {

      return new CustomerFindByIdInteractor(customerFindByIdGateway);
   }

   @Bean
   public CustomerIdentifyUseCase customerIdentifyUseCase(
         CustomerIdentifyGateway customerIdentifyGateway) {

      return new CustomerIdentifyInteractor(customerIdentifyGateway);
   }

   @Bean
   public CustomerRegistryValidator customerRegistryExistsValidator(
         CustomerIdentifyGateway customerIdentifyGateway) {

      return new CustomerRegistryExistsValidator(customerIdentifyGateway);
   }

   @Bean
   public CustomerRegistryUseCase customerRegistryUseCase(
         CustomerRegistryGateway customerRegistryGateway,
         List<CustomerRegistryValidator> listCustomerRegistryValidator) {

      return new CustomerRegistryInteractor(
            customerRegistryGateway, listCustomerRegistryValidator);
   }
}