package com.fiappostech.fastfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapters.outbound.CustomerFindByPersonalIdRepository;
import com.fiappostech.fastfood.adapters.outbound.OrderFindByIdRepository;
import com.fiappostech.fastfood.adapters.outbound.OrderFindByTrackingRepository;
import com.fiappostech.fastfood.adapters.outbound.OrderInsertRepository;
import com.fiappostech.fastfood.adapters.outbound.OrderUpdateRepository;
import com.fiappostech.fastfood.adapters.outbound.ProductFindByIdRepository;
import com.fiappostech.fastfood.application.core.usecases.OrderCheckoutService;
import com.fiappostech.fastfood.application.core.usecases.OrderFindByIdService;
import com.fiappostech.fastfood.application.core.usecases.OrderFindByTrackingService;
import com.fiappostech.fastfood.application.core.usecases.OrderInsertService;
import com.fiappostech.fastfood.application.core.usecases.OrderUpdateService;

@Configuration
public class OrderBeanConfig {

   @Bean
   public OrderInsertService orderInsertService(
         OrderInsertRepository orderInsertRepository,
         ProductFindByIdRepository productFindByIRepository,
         CustomerFindByPersonalIdRepository customerFindByPersonalIdRepository) {

      return new OrderInsertService(orderInsertRepository, productFindByIRepository, customerFindByPersonalIdRepository);
   }

   @Bean
   public OrderCheckoutService orderCheckoutService(
         OrderUpdateRepository orderUpdateRepository,
         OrderFindByIdRepository orderFindByIdRepository) {

      return new OrderCheckoutService(orderUpdateRepository, orderFindByIdRepository);
   }

   @Bean
   public OrderUpdateService orderUpdateService(
         OrderUpdateRepository orderUpdateRepository,
         OrderFindByIdRepository orderFindByIdRepository) {

      return new OrderUpdateService(orderUpdateRepository, orderFindByIdRepository);
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