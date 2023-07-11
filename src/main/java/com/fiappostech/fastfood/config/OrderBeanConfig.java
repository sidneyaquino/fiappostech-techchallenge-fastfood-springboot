package com.fiappostech.fastfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapters.outbound.CustomerFindByPersonalIdRepository;
import com.fiappostech.fastfood.adapters.outbound.OrderFindByIdRepository;
import com.fiappostech.fastfood.adapters.outbound.OrderFindByTrackingRepository;
import com.fiappostech.fastfood.adapters.outbound.OrderSaveRepository;
import com.fiappostech.fastfood.application.core.OrderFindByIdService;
import com.fiappostech.fastfood.application.core.OrderFindByTrackingService;
import com.fiappostech.fastfood.application.core.OrderInsertService;
import com.fiappostech.fastfood.application.core.OrderCheckoutService;

@Configuration
public class OrderBeanConfig {

   @Bean
   public OrderInsertService orderInsertService(OrderSaveRepository orderSaveRepository,
         CustomerFindByPersonalIdRepository customerFindByPersonalIdRepository) {

      return new OrderInsertService(orderSaveRepository, customerFindByPersonalIdRepository);
   }

   @Bean
   public OrderCheckoutService orderCheckoutService(OrderSaveRepository orderSaveRepository,
         OrderFindByIdRepository orderFindByIdRepository) {

      return new OrderCheckoutService(orderSaveRepository, orderFindByIdRepository);
   }

   @Bean
   public OrderFindByIdService orderFindByIdService(
         OrderFindByIdRepository orderFindByIdRepository) {

      return new OrderFindByIdService(orderFindByIdRepository);
   }

   @Bean
   public OrderFindByTrackingService orderFindByTrackingService(
         OrderFindByTrackingRepository orderFindByTrackingRepository) {

      return new OrderFindByTrackingService(orderFindByTrackingRepository);
   }
}