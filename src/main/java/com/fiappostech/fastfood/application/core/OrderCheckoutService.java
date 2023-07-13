package com.fiappostech.fastfood.application.core;

import java.time.LocalDateTime;

import com.fiappostech.fastfood.application.core.domain.OrderDomain;
import com.fiappostech.fastfood.application.ports.dto.Tracking;
import com.fiappostech.fastfood.application.ports.dto.request.OrderCheckoutRequest;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.exception.ApplicationException;
import com.fiappostech.fastfood.application.ports.inbound.OrderCheckoutInputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderFindByIdOutputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderUpdateOutputPort;

public class OrderCheckoutService implements OrderCheckoutInputPort {

   private final OrderUpdateOutputPort orderUpdateOutputPort;
   private final OrderFindByIdOutputPort orderFindByIdOutputPort;

   public OrderCheckoutService(
         OrderUpdateOutputPort orderUpdateOutputPort,
         OrderFindByIdOutputPort orderFindByIdOutputPort) {

      this.orderUpdateOutputPort = orderUpdateOutputPort;
      this.orderFindByIdOutputPort = orderFindByIdOutputPort;
   }

   @Override
   public OrderResponse execute(OrderCheckoutRequest orderCheckoutRequest) {
      var orderDomain = new OrderDomain(orderCheckoutRequest);

      //
      // Business Rules before Request (validation).
      //
      var orderResponse = this.orderFindByIdOutputPort.execute(orderDomain.getOrderId());

      if (orderResponse.tracking() != null) {
         throw new ApplicationException("Order checkout already done");
      }
      if (orderResponse.value().compareTo(orderDomain.getValue()) != 0) {
         throw new ApplicationException("Incorrect Order Value!");
      }
      orderDomain.setTracked(LocalDateTime.now());
      orderDomain.setTracking(Tracking.RECEIVED);
      //
      // Request.
      //
      orderResponse = this.orderUpdateOutputPort.execute(orderDomain.toOrderRequest());
      orderDomain = new OrderDomain(orderResponse);
      //
      // Business Rules before Response.
      //

      return orderDomain.toOrderResponse();
   }
}