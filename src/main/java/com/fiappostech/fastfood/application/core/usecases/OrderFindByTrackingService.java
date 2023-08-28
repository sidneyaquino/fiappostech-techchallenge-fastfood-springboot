package com.fiappostech.fastfood.application.core.usecases;

import java.util.List;

import com.fiappostech.fastfood.application.core.domain.OrderDomain;
import com.fiappostech.fastfood.application.ports.dto.Tracking;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.inbound.OrderFindByTrackingInputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderFindByTrackingOutputPort;

public class OrderFindByTrackingService implements OrderFindByTrackingInputPort {
   
   private final OrderFindByTrackingOutputPort orderFindByTrackingOutputPort;

   public OrderFindByTrackingService(OrderFindByTrackingOutputPort orderFindByTrackingOutputPort) {
      this.orderFindByTrackingOutputPort = orderFindByTrackingOutputPort;
   }

   @Override
   public List<OrderResponse> execute(Tracking tracking) {
      
      //
      // Business Rules before Request.
      //
      var listOrderResponse = this.orderFindByTrackingOutputPort.execute(tracking);
      var listOrderDomain = listOrderResponse.stream().map(OrderDomain::new).toList();
      //
      // Business Rules before Response.
      //

      return listOrderDomain.stream().map(item -> item.toOrderResponse()).toList();
   }
}