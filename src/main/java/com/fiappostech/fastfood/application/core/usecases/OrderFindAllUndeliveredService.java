package com.fiappostech.fastfood.application.core.usecases;

import java.util.ArrayList;
import java.util.List;

import com.fiappostech.fastfood.application.core.domain.OrderDomain;
import com.fiappostech.fastfood.application.ports.dto.OrderTracking;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.inbound.OrderFindAllUndeliveredInputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderFindAllUndeliveredOutputPort;

public class OrderFindAllUndeliveredService implements OrderFindAllUndeliveredInputPort {
   
   private final OrderFindAllUndeliveredOutputPort orderFindAllUndeliveredOutputPort;

   public OrderFindAllUndeliveredService(OrderFindAllUndeliveredOutputPort orderFindAllUndeliveredOutputPort) {
      this.orderFindAllUndeliveredOutputPort = orderFindAllUndeliveredOutputPort;
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
      var listOrderResponse = this.orderFindAllUndeliveredOutputPort.execute(listTracking);
      var listOrderDomain = listOrderResponse.stream().map(OrderDomain::new).toList();
      //
      // Business Rules before Response.
      //

      return listOrderDomain.stream().map(item -> item.toOrderResponse()).toList();
   }
}