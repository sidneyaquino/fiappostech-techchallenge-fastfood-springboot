package com.fiappostech.fastfood.adapter.gateway.order;

import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderInsertRepository;

public class OrderInsertRepositoryGateway implements OrderInsertGateway {

   private final OrderInsertRepository orderInsertRepository;

   public OrderInsertRepositoryGateway(OrderInsertRepository orderInsertRepository) {
      this.orderInsertRepository = orderInsertRepository;
   }

   @Override
   public OrderResponse execute(OrderRequest orderRequest) {
      return orderInsertRepository.execute(orderRequest);
   }
}