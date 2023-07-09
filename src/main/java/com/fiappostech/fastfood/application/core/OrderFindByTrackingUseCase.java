package com.fiappostech.fastfood.application.core;

import java.util.List;

import com.fiappostech.fastfood.application.ports.dto.Tracking;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.inbound.OrderFindByTrackingInputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderFindByTrackingOutputPort;

public class OrderFindByTrackingUseCase implements OrderFindByTrackingInputPort {
   
   private final OrderFindByTrackingOutputPort orderFindByTrackingOutputPort;

   public OrderFindByTrackingUseCase(OrderFindByTrackingOutputPort orderFindByTrackingOutputPort) {
      this.orderFindByTrackingOutputPort = orderFindByTrackingOutputPort;
   }

   @Override
   public List<OrderResponse> execute(Tracking tracking) {
      
      //
      // Business Rules before Request.
      //
      var listOrderResponse = this.orderFindByTrackingOutputPort.execute(tracking);
      //
      // Business Rules before Response.
      //

      return listOrderResponse;
   }
}