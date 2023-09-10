package com.fiappostech.fastfood.adapter.presenter.order;

import com.fiappostech.fastfood.adapter.presenter.order.request.OrderPostRequest;
import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseFull;
import com.fiappostech.fastfood.application.usecase.order.OrderInsertUseCase;

public class OrderInsertControllerPresenter implements OrderInsertPresenter{

   private final OrderInsertUseCase orderInsertUseCase;

   public OrderInsertControllerPresenter(OrderInsertUseCase orderInsertUseCase) {
      this.orderInsertUseCase = orderInsertUseCase;
   }

   public OrderResponseFull execute(OrderPostRequest orderPostRequest) {
      return new OrderResponseFull(orderInsertUseCase.execute(orderPostRequest.toOrderRequest()));
   }
}