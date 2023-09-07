package com.fiappostech.fastfood.adapter.presenter.order;

import com.fiappostech.fastfood.adapter.presenter.order.request.OrderPutRequest;
import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;
import com.fiappostech.fastfood.domain.port.order.OrderUpdateUseCase;

public class OrderUpdatePresenter {

   private final OrderUpdateUseCase orderUpdateUseCase;

   public OrderUpdatePresenter(OrderUpdateUseCase orderUpdateUseCase) {
      this.orderUpdateUseCase = orderUpdateUseCase;
   }

   public OrderResponseTracking execute(OrderPutRequest orderPutRequest) {
      return new OrderResponseTracking(orderUpdateUseCase.execute(orderPutRequest.toOrderRequest()));
   }
}