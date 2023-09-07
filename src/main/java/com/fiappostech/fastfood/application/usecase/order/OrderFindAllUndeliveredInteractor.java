package com.fiappostech.fastfood.application.usecase.order;

import java.util.ArrayList;
import java.util.List;

import com.fiappostech.fastfood.application.port.order.OrderFindAllUndeliveredGateway;
import com.fiappostech.fastfood.domain.entity.OrderDomain;
import com.fiappostech.fastfood.domain.entity.OrderTracking;
import com.fiappostech.fastfood.domain.port.order.OrderFindAllUndeliveredUseCase;
import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;

public class OrderFindAllUndeliveredInteractor implements OrderFindAllUndeliveredUseCase {
   
   private final OrderFindAllUndeliveredGateway orderFindAllUndeliveredGateway;

   public OrderFindAllUndeliveredInteractor(OrderFindAllUndeliveredGateway orderFindAllUndeliveredGateway) {
      this.orderFindAllUndeliveredGateway = orderFindAllUndeliveredGateway;
   }

   @Override
   public List<OrderResponse> execute() {
      
      //
      // Business Rules before Request.
      //
      var listTracking = new ArrayList<OrderTracking>();
      listTracking.add(OrderTracking.RECEIVED);
      listTracking.add(OrderTracking.PREPARING);
      listTracking.add(OrderTracking.READY);
      var listOrderResponse = this.orderFindAllUndeliveredGateway.execute(listTracking);
      var listOrderDomain = listOrderResponse.stream().map(OrderDomain::new).toList();
      //
      // Business Rules before Response.
      //

      return listOrderDomain.stream().map(item -> item.toOrderResponse()).toList();
   }
}