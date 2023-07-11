package com.fiappostech.fastfood.application.core;

import java.util.UUID;

import com.fiappostech.fastfood.application.core.domain.OrderDomain;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.inbound.OrderFindByIdInputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderFindByIdOutputPort;

public class OrderFindByIdService implements OrderFindByIdInputPort {
   
   private final OrderFindByIdOutputPort orderFindByIdOutputPort;

   public OrderFindByIdService(OrderFindByIdOutputPort orderFindByIdOutputPort) {
      this.orderFindByIdOutputPort = orderFindByIdOutputPort;
   }

   @Override
   public OrderResponse execute(UUID orderId) {
      
      //
      // Business Rules before Request.
      //
      var orderResponse = this.orderFindByIdOutputPort.execute(orderId);
      var orderDomain = new OrderDomain(orderResponse);
      //
      // Business Rules before Response.
      //

      return orderDomain.toOrderResponse();
   }
}