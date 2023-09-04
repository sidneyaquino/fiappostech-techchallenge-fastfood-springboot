package com.fiappostech.fastfood.application.core.usecases;

import java.time.LocalDateTime;

import com.fiappostech.fastfood.application.core.domain.OrderDomain;
import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.exception.ApplicationException;
import com.fiappostech.fastfood.application.ports.inbound.OrderUpdateInputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderFindByIdOutputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderUpdateOutputPort;

public class OrderUpdateService implements OrderUpdateInputPort {

   private final OrderUpdateOutputPort orderUpdateOutputPort;
   private final OrderFindByIdOutputPort orderFindByIdOutputPort;

   public OrderUpdateService(
         OrderUpdateOutputPort orderUpdateOutputPort,
         OrderFindByIdOutputPort orderFindByIdOutputPort) {

      this.orderUpdateOutputPort = orderUpdateOutputPort;
      this.orderFindByIdOutputPort = orderFindByIdOutputPort;
   }

   @Override
   public OrderResponse execute(OrderRequest orderRequest) {
      var orderDomain = new OrderDomain(orderRequest);

      //
      // Business Rules before Request (validation).
      //
      var orderResponse = this.orderFindByIdOutputPort.execute(orderDomain.getOrderId());

      if (orderResponse.created() == null) {
         throw new ApplicationException("Order without checkout process...");
      }
      if (orderResponse.tracking() == null) {
         throw new ApplicationException("Order pending payment process...");
      }
      
      if (!orderResponse.tracking().equals(orderDomain.getTracking())) {
         orderDomain.setTracked(LocalDateTime.now());
         orderDomain.setTracking(orderRequest.tracking());
         //
         // Request.
         //
         orderResponse = this.orderUpdateOutputPort.execute(orderDomain.toOrderRequest());  
      }
      orderDomain = new OrderDomain(orderResponse);       
      //
      // Business Rules before Response.
      //

      return orderDomain.toOrderResponse();
   }
}