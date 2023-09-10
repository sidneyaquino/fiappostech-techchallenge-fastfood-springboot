package com.fiappostech.fastfood.infrastructure.config.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapter.presenter.customer.CustomerFindByIdPresenter;
import com.fiappostech.fastfood.adapter.presenter.customer.CustomerFindByIdControllerPresenter;
import com.fiappostech.fastfood.adapter.presenter.customer.CustomerIdentifyPresenter;
import com.fiappostech.fastfood.adapter.presenter.customer.CustomerIdentifyControllerPresenter;
import com.fiappostech.fastfood.adapter.presenter.customer.CustomerRegistryPresenter;
import com.fiappostech.fastfood.adapter.presenter.customer.CustomerRegistryControllerPresenter;
import com.fiappostech.fastfood.application.usecase.customer.CustomerFindByIdUseCase;
import com.fiappostech.fastfood.application.usecase.customer.CustomerIdentifyUseCase;
import com.fiappostech.fastfood.application.usecase.customer.CustomerRegistryUseCase;

@Configuration
public class CustomerPresenterConfig {

   @Bean
   public CustomerFindByIdPresenter customerFindByIdPresenter(
         CustomerFindByIdUseCase customerFindByIdUseCase) {

      return new CustomerFindByIdControllerPresenter(customerFindByIdUseCase);
   }

   @Bean
   public CustomerIdentifyPresenter customerIdentifyPresenter(
         CustomerIdentifyUseCase customerIdentifyUseCase) {

      return new CustomerIdentifyControllerPresenter(customerIdentifyUseCase);
   }

   @Bean
   public CustomerRegistryPresenter customerRegistryPresenter(
         CustomerRegistryUseCase customerRegistryUseCase) {

      return new CustomerRegistryControllerPresenter(customerRegistryUseCase);
   }
}