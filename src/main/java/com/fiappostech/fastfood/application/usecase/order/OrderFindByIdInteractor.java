package com.fiappostech.fastfood.application.usecase.order;

import java.util.UUID;

import com.fiappostech.fastfood.adapter.gateway.order.OrderFindByIdGateway;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.domain.entity.OrderDomain;

public class OrderFindByIdInteractor implements OrderFindByIdUseCase {
   
   private final OrderFindByIdGateway orderFindByIdGateway;

   public OrderFindByIdInteractor(OrderFindByIdGateway orderFindByIdGateway) {
      this.orderFindByIdGateway = orderFindByIdGateway;
   }

   @Override
   public OrderResponse execute(UUID orderId) {
      
      //
      // Business Rules before Request.
      //
      var orderResponse = this.orderFindByIdGateway.execute(orderId);
      var orderDomain = new OrderDomain(orderResponse);
      //
      // Business Rules before Response.
      //

      return orderDomain.toOrderResponse();
   }
}