package com.fiappostech.fastfood.application.core;

import com.fiappostech.fastfood.application.core.domain.OrderDomain;
import com.fiappostech.fastfood.application.ports.dto.request.OrderCheckoutRequest;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.inbound.OrderCheckoutInputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderFindByIdOutputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderSaveOutputPort;

public class OrderCheckoutService implements OrderCheckoutInputPort {

   private final OrderSaveOutputPort orderSaveOutputPort;
   private final OrderFindByIdOutputPort orderFindByIdOutputPort;

   public OrderCheckoutService(
         OrderSaveOutputPort orderSaveOutputPort,
         OrderFindByIdOutputPort orderFindByIdOutputPort) {

      this.orderSaveOutputPort = orderSaveOutputPort;
      this.orderFindByIdOutputPort = orderFindByIdOutputPort;
   }

   @Override
   public OrderResponse execute(OrderCheckoutRequest orderCheckoutRequest) {
      var orderDomain = new OrderDomain(orderCheckoutRequest);

      // PENDENCIA!

      // Business Rules before Request (validation).
      var orderResponse = this.orderFindByIdOutputPort.execute(orderDomain.getOrderId());
      if (orderResponse.tracking() != null) {
         // throw new Exception("Payment alredy done!");
      }
      // if (orderResponse.value().compareTo(orderDomain.getValue()) != 0) {
      //    // throw new Exception("Incorrect Value!");
      // }

      //
      // Request.
      orderResponse = this.orderSaveOutputPort.execute(orderDomain.toOrderRequest());
      orderDomain = new OrderDomain(orderResponse);
      //
      // Business Rules before Response.
      //

      return orderDomain.toOrderResponse();
   }
}