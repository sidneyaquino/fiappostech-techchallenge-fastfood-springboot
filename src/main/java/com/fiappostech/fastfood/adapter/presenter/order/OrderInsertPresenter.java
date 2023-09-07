package com.fiappostech.fastfood.adapter.presenter.order;

import com.fiappostech.fastfood.adapter.presenter.order.request.OrderPostRequest;
import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseFull;
import com.fiappostech.fastfood.domain.port.order.OrderInsertUseCase;

public class OrderInsertPresenter {

   private final OrderInsertUseCase orderInsertUseCase;

   public OrderInsertPresenter(OrderInsertUseCase orderInsertUseCase) {
      this.orderInsertUseCase = orderInsertUseCase;
   }

   public OrderResponseFull execute(OrderPostRequest orderPostRequest) {
      return new OrderResponseFull(orderInsertUseCase.execute(orderPostRequest.toOrderRequest()));
   }
}