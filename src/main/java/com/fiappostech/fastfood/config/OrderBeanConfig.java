package com.fiappostech.fastfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapters.outbound.CustomerIdentifyServiceAdapter;
import com.fiappostech.fastfood.adapters.outbound.OrderFindByIdServiceAdapter;
import com.fiappostech.fastfood.adapters.outbound.OrderFindByTrackingServiceAdapter;
import com.fiappostech.fastfood.adapters.outbound.OrderSaveServiceAdapter;
import com.fiappostech.fastfood.application.core.OrderFindByIdUseCase;
import com.fiappostech.fastfood.application.core.OrderFindByTrackingUseCase;
import com.fiappostech.fastfood.application.core.OrderInsertUseCase;

@Configuration
public class OrderBeanConfig {

   @Bean
   public OrderInsertUseCase orderInsertUseCase(
         OrderSaveServiceAdapter orderSaveServiceAdapter,
         CustomerIdentifyServiceAdapter customerIdentifyServiceAdapter) {

      return new OrderInsertUseCase(orderSaveServiceAdapter, customerIdentifyServiceAdapter);
   }

   @Bean
   public OrderFindByIdUseCase orderFindByIdUseCase(
         OrderFindByIdServiceAdapter orderFindByIdServiceAdapter) {

      return new OrderFindByIdUseCase(orderFindByIdServiceAdapter);
   }

   @Bean
   public OrderFindByTrackingUseCase orderFindUseCase(
         OrderFindByTrackingServiceAdapter orderFindByTrackingServiceAdapter) {

      return new OrderFindByTrackingUseCase(orderFindByTrackingServiceAdapter);
   }
}