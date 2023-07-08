package com.fiappostech.fastfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapters.outbound.CustomerIdentifyServiceAdapter;
import com.fiappostech.fastfood.adapters.outbound.OrderSaveServiceAdapter;
import com.fiappostech.fastfood.application.core.OrderInsertUseCase;

@Configuration
public class OrderBeanConfig {

   @Bean
   public OrderInsertUseCase orderInsertUseCase(
         OrderSaveServiceAdapter orderSaveServiceAdapter,
         CustomerIdentifyServiceAdapter customerIdentifyServiceAdapter) {

      return new OrderInsertUseCase(orderSaveServiceAdapter, customerIdentifyServiceAdapter);
   }
}