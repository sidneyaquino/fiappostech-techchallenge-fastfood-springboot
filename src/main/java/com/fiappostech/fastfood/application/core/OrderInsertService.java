package com.fiappostech.fastfood.application.core;

import java.time.LocalDateTime;

import com.fiappostech.fastfood.application.core.domain.CustomerDomain;
import com.fiappostech.fastfood.application.core.domain.OrderDomain;
import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.inbound.OrderInsertInputPort;
import com.fiappostech.fastfood.application.ports.outbound.CustomerIdentifyOutputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderInsertOutputPort;

public class OrderInsertService implements OrderInsertInputPort {

   private final OrderInsertOutputPort orderInsertOutputPort;
   private final CustomerIdentifyOutputPort customerIdentifyOutputPort;

   public OrderInsertService(
         OrderInsertOutputPort orderInsertOutputPort,
         CustomerIdentifyOutputPort customerIdentifyOutputPort) {

      this.orderInsertOutputPort = orderInsertOutputPort;
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
      //
      // PENDENCIA! Validar Itens.
      // 

      orderDomain.setCreated(LocalDateTime.now());
      //
      // Request.
      var orderResponse = this.orderInsertOutputPort.execute(orderDomain.toOrderRequest());
      orderDomain = new OrderDomain(orderResponse);
      //
      // Business Rules before Response.
      //

      return orderDomain.toOrderResponse();
   }
}