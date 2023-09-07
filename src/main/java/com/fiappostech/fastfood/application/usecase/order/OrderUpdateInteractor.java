package com.fiappostech.fastfood.application.usecase.order;

import java.time.LocalDateTime;

import com.fiappostech.fastfood.application.exception.BusinessException;
import com.fiappostech.fastfood.application.port.order.OrderFindByIdGateway;
import com.fiappostech.fastfood.application.port.order.OrderUpdateGateway;
import com.fiappostech.fastfood.domain.entity.OrderDomain;
import com.fiappostech.fastfood.domain.port.order.OrderUpdateUseCase;
import com.fiappostech.fastfood.domain.port.order.dto.OrderRequest;
import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;

public class OrderUpdateInteractor implements OrderUpdateUseCase {

   private final OrderUpdateGateway orderUpdateGateway;
   private final OrderFindByIdGateway orderFindByIdGateway;

   public OrderUpdateInteractor(
         OrderUpdateGateway orderUpdateGateway,
         OrderFindByIdGateway orderFindByIdGateway) {

      this.orderUpdateGateway = orderUpdateGateway;
      this.orderFindByIdGateway = orderFindByIdGateway;
   }

   @Override
   public OrderResponse execute(OrderRequest orderRequest) {
      var orderDomain = new OrderDomain(orderRequest);

      //
      // Business Rules before Request (validation).
      //
      var orderResponse = this.orderFindByIdGateway.execute(orderDomain.getOrderId());

      if (orderResponse.created() == null) {
         throw new BusinessException("Order without checkout process...");
      }
      if (orderResponse.tracking() == null) {
         throw new BusinessException("Order pending payment process...");
      }
      
      if (!orderResponse.tracking().equals(orderDomain.getTracking())) {
         orderDomain.setTracked(LocalDateTime.now());
         orderDomain.setTracking(orderRequest.tracking());
         //
         // Request.
         //
         orderResponse = this.orderUpdateGateway.execute(orderDomain.toOrderRequest());  
      }
      orderDomain = new OrderDomain(orderResponse);       
      //
      // Business Rules before Response.
      //

      return orderDomain.toOrderResponse();
   }
}