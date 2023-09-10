package com.fiappostech.fastfood.adapter.gateway.order;

import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderUpdateRepository;

public class OrderUpdateRepositoryGateway implements OrderUpdateGateway {

   private final OrderUpdateRepository orderUpdateRepository;

   public OrderUpdateRepositoryGateway(OrderUpdateRepository orderUpdateRepository) {
      this.orderUpdateRepository = orderUpdateRepository;
   }

   @Override
   public OrderResponse execute(OrderRequest orderRequest) {
      return orderUpdateRepository.execute(orderRequest);
   }
}