package com.fiappostech.fastfood.adapter.gateway.order;

import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderFindByIdRepository;

public class OrderFindByIdRepositoryGateway implements OrderFindByIdGateway {

   private final OrderFindByIdRepository orderFindByIdRepositoryRepository;

   public OrderFindByIdRepositoryGateway(OrderFindByIdRepository orderFindByIdRepositoryRepository) {
      this.orderFindByIdRepositoryRepository = orderFindByIdRepositoryRepository;
   }

   @Override
   public OrderResponse execute(UUID orderId) {
      return orderFindByIdRepositoryRepository.execute(orderId);
   }
}