package com.fiappostech.fastfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapters.outbound.CustomerFindByPersonalIdRepository;
import com.fiappostech.fastfood.adapters.outbound.OrderFindAllUndeliveredRepository;
import com.fiappostech.fastfood.adapters.outbound.OrderFindByIdRepository;
import com.fiappostech.fastfood.adapters.outbound.OrderFindByTrackingRepository;
import com.fiappostech.fastfood.adapters.outbound.OrderInsertRepository;
import com.fiappostech.fastfood.adapters.outbound.OrderUpdateRepository;
import com.fiappostech.fastfood.adapters.outbound.ProductFindByIdRepository;
import com.fiappostech.fastfood.application.core.usecases.OrderCheckoutService;
import com.fiappostech.fastfood.application.core.usecases.OrderFindAllUndeliveredService;
import com.fiappostech.fastfood.application.core.usecases.OrderFindByIdService;
import com.fiappostech.fastfood.application.core.usecases.OrderFindByTrackingService;
import com.fiappostech.fastfood.application.core.usecases.OrderInsertService;
import com.fiappostech.fastfood.application.core.usecases.OrderUpdateService;
import com.fiappostech.fastfood.application.ports.outbound.PaymentInsertOutputPort;

@Configuration
public class OrderBeanConfig {

   @Bean
   public OrderInsertService orderInsertService(
         OrderInsertRepository orderInsertRepository,
         ProductFindByIdRepository productFindByIRepository,
         CustomerFindByPersonalIdRepository customerFindByPersonalIdRepository) {

      return new OrderInsertService(
            orderInsertRepository, productFindByIRepository, customerFindByPersonalIdRepository);
   }

   @Bean
   public OrderCheckoutService orderCheckoutService(
         OrderUpdateRepository orderUpdateRepository,
         OrderFindByIdRepository orderFindByIdRepository,
         PaymentInsertOutputPort paymentInsertOutputPort) {

      return new OrderCheckoutService(
            orderUpdateRepository, orderFindByIdRepository, paymentInsertOutputPort);
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

   @Bean
   public OrderFindAllUndeliveredService orderFindAllUndeliveredService(
         OrderFindAllUndeliveredRepository orderFindAllUndeliveredRepository) {

      return new OrderFindAllUndeliveredService(orderFindAllUndeliveredRepository);
   }
}