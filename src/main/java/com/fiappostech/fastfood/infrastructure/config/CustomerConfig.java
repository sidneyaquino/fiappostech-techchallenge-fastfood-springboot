package com.fiappostech.fastfood.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapter.presenter.customer.CustomerFindByIdPresenter;
import com.fiappostech.fastfood.adapter.presenter.customer.CustomerIdentifyPresenter;
import com.fiappostech.fastfood.adapter.presenter.customer.CustomerRegistryPresenter;
import com.fiappostech.fastfood.application.usecase.customer.CustomerFindByIdInteractor;
import com.fiappostech.fastfood.application.usecase.customer.CustomerIdentifyInteractor;
import com.fiappostech.fastfood.application.usecase.customer.CustomerRegistryInteractor;
import com.fiappostech.fastfood.domain.port.customer.CustomerFindByIdUseCase;
import com.fiappostech.fastfood.domain.port.customer.CustomerIdentifyUseCase;
import com.fiappostech.fastfood.domain.port.customer.CustomerRegistryUseCase;
import com.fiappostech.fastfood.infrastructure.persistence.customer.CustomerFindByIdRepository;
import com.fiappostech.fastfood.infrastructure.persistence.customer.CustomerFindByPersonalIdRepository;
import com.fiappostech.fastfood.infrastructure.persistence.customer.CustomerSaveRepository;

@Configuration
public class CustomerConfig {

   @Bean
   public CustomerFindByIdPresenter customerFindByIdPresenter(
         CustomerFindByIdUseCase customerFindByIdUseCase) {

      return new CustomerFindByIdPresenter(customerFindByIdUseCase);
   }

   @Bean
   public CustomerIdentifyPresenter customerIdentifyPresenter(
         CustomerIdentifyUseCase customerIdentifyUseCase) {

      return new CustomerIdentifyPresenter(customerIdentifyUseCase);
   }

   @Bean
   public CustomerRegistryPresenter customerRegistryPresenter(
         CustomerRegistryUseCase customerRegistryUseCase) {

      return new CustomerRegistryPresenter(customerRegistryUseCase);
   }

   @Bean
   public CustomerRegistryInteractor customerRegistryInteractor(
         CustomerSaveRepository customerSaveRepository) {

      return new CustomerRegistryInteractor(customerSaveRepository);
   }

   @Bean
   public CustomerFindByIdInteractor customerFindByIdInteractor(
         CustomerFindByIdRepository customerFindByIdRepository) {

      return new CustomerFindByIdInteractor(customerFindByIdRepository);
   }

   @Bean
   public CustomerIdentifyInteractor customerIdentifyInteractor(
         CustomerFindByPersonalIdRepository customerFindByPersonalIdRepository) {

      return new CustomerIdentifyInteractor(customerFindByPersonalIdRepository);
   }
}