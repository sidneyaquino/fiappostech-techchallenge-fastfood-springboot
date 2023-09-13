package com.fiappostech.fastfood.application.usecase.order;

import java.time.LocalDateTime;
import java.util.List;

import com.fiappostech.fastfood.adapter.gateway.order.OrderFindByIdGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderUpdateGateway;
import com.fiappostech.fastfood.application.usecase.order.validator.OrderUpdateValidator;
import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.domain.entity.OrderDomain;

public class OrderUpdateInteractor implements OrderUpdateUseCase {

   private final OrderUpdateGateway orderUpdateGateway;
   private final OrderFindByIdGateway orderFindByIdGateway;
   private final List<OrderUpdateValidator> listOrderUpdateValidator;

   public OrderUpdateInteractor(
         OrderUpdateGateway orderUpdateGateway,
         OrderFindByIdGateway orderFindByIdGateway,
         List<OrderUpdateValidator> listOrderUpdateValidator) {

      this.orderUpdateGateway = orderUpdateGateway;
      this.orderFindByIdGateway = orderFindByIdGateway;
      this.listOrderUpdateValidator = listOrderUpdateValidator;
   }

   @Override
   public OrderResponse execute(OrderRequest orderRequest) {

      //
      // Business Rules before Request (validation).
      //
      final var orderResponse = this.orderFindByIdGateway.execute(orderRequest.orderId());
      listOrderUpdateValidator.forEach(item -> item.validate(orderRequest, orderResponse));

      var orderDomain = new OrderDomain(orderRequest);
      orderDomain.setTracking(orderRequest.tracking());
      orderDomain.setTracked(LocalDateTime.now());

      //
      // Request.
      //      
      orderDomain = new OrderDomain(this.orderUpdateGateway.execute(orderDomain.toOrderRequest()));

      //
      // Business Rules before Response.
      //

      return orderDomain.toOrderResponse();
   }
}