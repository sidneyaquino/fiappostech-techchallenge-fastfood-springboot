package com.fiappostech.fastfood.adapter.presenter.order;

import com.fiappostech.fastfood.adapter.presenter.order.request.OrderPutRequest;
import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;
import com.fiappostech.fastfood.application.usecase.order.OrderUpdateUseCase;

public class OrderUpdateControllerPresenter implements OrderUpdatePresenter {

   private final OrderUpdateUseCase orderUpdateUseCase;

   public OrderUpdateControllerPresenter(OrderUpdateUseCase orderUpdateUseCase) {
      this.orderUpdateUseCase = orderUpdateUseCase;
   }

   public OrderResponseTracking execute(OrderPutRequest orderPutRequest) {
      return new OrderResponseTracking(orderUpdateUseCase.execute(orderPutRequest.toOrderRequest()));
   }
}