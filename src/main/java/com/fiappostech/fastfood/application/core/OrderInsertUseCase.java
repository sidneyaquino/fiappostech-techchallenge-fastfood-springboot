package com.fiappostech.fastfood.application.core;

import java.time.LocalDateTime;

import com.fiappostech.fastfood.application.core.domain.CustomerDomain;
import com.fiappostech.fastfood.application.core.domain.OrderDomain;
import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.inbound.OrderInsertInputPort;
import com.fiappostech.fastfood.application.ports.outbound.CustomerIdentifyOutputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderSaveOutputPort;

public class OrderInsertUseCase implements OrderInsertInputPort {

   private final OrderSaveOutputPort orderSaveOutputPort;
   private final CustomerIdentifyOutputPort customerIdentifyOutputPort;

   public OrderInsertUseCase(
         OrderSaveOutputPort orderSaveOutputPort,
         CustomerIdentifyOutputPort customerIdentifyOutputPort) {

      this.orderSaveOutputPort = orderSaveOutputPort;
      this.customerIdentifyOutputPort = customerIdentifyOutputPort;
   }

   @Override
   public OrderResponse execute(OrderRequest orderRequest) {
      var orderDomain = new OrderDomain(orderRequest);

      // Business Rules before Request (validation).
      if (orderDomain.getCustomer() != null) {
         var personalId = orderDomain.getCustomer().getPersonalId().personalId();
         var customerResponse = this.customerIdentifyOutputPort.execute(personalId);
         orderDomain.setCustomer(new CustomerDomain(customerResponse));
      }
      orderDomain.setCreated(LocalDateTime.now());
      //
      // Request.
      var orderResponse = this.orderSaveOutputPort.execute(orderDomain.toOrderRequest());
      orderDomain = new OrderDomain(orderResponse);
      //
      // Business Rules before Response.
      //

      return orderDomain.toOrderResponse();
   }
}