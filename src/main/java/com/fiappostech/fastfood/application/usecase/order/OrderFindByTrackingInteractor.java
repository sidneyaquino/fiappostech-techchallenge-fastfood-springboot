package com.fiappostech.fastfood.application.usecase.order;

import java.util.List;

import com.fiappostech.fastfood.adapter.gateway.order.OrderFindByTrackingGateway;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.domain.entity.OrderDomain;
import com.fiappostech.fastfood.domain.entity.OrderTracking;

public class OrderFindByTrackingInteractor implements OrderFindByTrackingUseCase {
   
   private final OrderFindByTrackingGateway orderFindByTrackingGateway;

   public OrderFindByTrackingInteractor(OrderFindByTrackingGateway orderFindByTrackingGateway) {
      this.orderFindByTrackingGateway = orderFindByTrackingGateway;
   }

   @Override
   public List<OrderResponse> execute(OrderTracking tracking) {
      
      //
      // Business Rules before Request.
      //

      //
      // Request.
      //      
      var listOrderResponse = this.orderFindByTrackingGateway.execute(tracking);
      var listOrderDomain = listOrderResponse.stream().map(OrderDomain::new).toList();
      
      //
      // Business Rules before Response.
      //

      return listOrderDomain.stream().map(item -> item.toOrderResponse()).toList();
   }
}