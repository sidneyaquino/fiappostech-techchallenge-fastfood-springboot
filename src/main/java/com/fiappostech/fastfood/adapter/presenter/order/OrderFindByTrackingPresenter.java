package com.fiappostech.fastfood.adapter.presenter.order;

import java.util.List;

import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;
import com.fiappostech.fastfood.domain.entity.OrderTracking;
import com.fiappostech.fastfood.domain.port.order.OrderFindByTrackingUseCase;
import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;

public class OrderFindByTrackingPresenter {

   private final OrderFindByTrackingUseCase orderFindByTrackingUseCase;

   public OrderFindByTrackingPresenter(OrderFindByTrackingUseCase orderFindByTrackingUseCase) {
      this.orderFindByTrackingUseCase = orderFindByTrackingUseCase;
   }

   public List<OrderResponseTracking> orderFindByTracking(OrderTracking tracking) {
      List<OrderResponse> listOrderResponse = orderFindByTrackingUseCase.execute(tracking);
      return listOrderResponse.stream().map(item -> new OrderResponseTracking(item)).toList();
   }
}