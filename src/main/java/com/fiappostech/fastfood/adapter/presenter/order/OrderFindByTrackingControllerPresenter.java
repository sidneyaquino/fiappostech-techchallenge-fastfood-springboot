package com.fiappostech.fastfood.adapter.presenter.order;

import java.util.List;

import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;
import com.fiappostech.fastfood.application.usecase.order.OrderFindByTrackingUseCase;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.domain.entity.OrderTracking;

public class OrderFindByTrackingControllerPresenter implements OrderFindByTrackingPresenter {

   private final OrderFindByTrackingUseCase orderFindByTrackingUseCase;

   public OrderFindByTrackingControllerPresenter(OrderFindByTrackingUseCase orderFindByTrackingUseCase) {
      this.orderFindByTrackingUseCase = orderFindByTrackingUseCase;
   }

   public List<OrderResponseTracking> execute(OrderTracking tracking) {
      List<OrderResponse> listOrderResponse = orderFindByTrackingUseCase.execute(tracking);
      return listOrderResponse.stream().map(item -> new OrderResponseTracking(item)).toList();
   }
}