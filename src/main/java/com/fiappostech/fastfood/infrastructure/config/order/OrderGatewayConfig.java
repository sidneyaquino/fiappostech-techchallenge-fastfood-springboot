package com.fiappostech.fastfood.infrastructure.config.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapter.gateway.order.OrderFindAllUndeliveredGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderFindAllUndeliveredRepositoryGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderFindByIdGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderFindByIdRepositoryGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderFindByTrackingGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderFindByTrackingRepositoryGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderInsertGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderInsertRepositoryGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderUpdateGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderUpdateRepositoryGateway;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderFindAllUndeliveredRepository;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderFindByIdRepository;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderFindByTrackingRepository;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderInsertRepository;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderUpdateRepository;

@Configuration
public class OrderGatewayConfig {
   @Bean
   public OrderInsertGateway orderInsertGateway(
         OrderInsertRepository orderInsertRepository) {

      return new OrderInsertRepositoryGateway(orderInsertRepository);
   }

   @Bean
   public OrderUpdateGateway orderUpdateGateway(
         OrderUpdateRepository orderUpdateRepository) {

      return new OrderUpdateRepositoryGateway(orderUpdateRepository);
   }

   @Bean
   public OrderFindByIdGateway orderFindByIdGateway(
         OrderFindByIdRepository orderFindByIdRepository) {

      return new OrderFindByIdRepositoryGateway(orderFindByIdRepository);
   }

   @Bean
   public OrderFindByTrackingGateway orderFindByTrackingGateway(
         OrderFindByTrackingRepository orderFindByTrackingRepository) {

      return new OrderFindByTrackingRepositoryGateway(orderFindByTrackingRepository);
   }

   @Bean
   public OrderFindAllUndeliveredGateway orderFindAllUndeliveredGateway(
         OrderFindAllUndeliveredRepository orderFindAllUndeliveredRepository) {

      return new OrderFindAllUndeliveredRepositoryGateway(orderFindAllUndeliveredRepository);
   }   
}