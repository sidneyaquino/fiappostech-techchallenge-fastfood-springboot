package com.fiappostech.fastfood.adapter.presenter.order;

import java.util.UUID;

import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseFull;
import com.fiappostech.fastfood.application.usecase.order.OrderFindByIdUseCase;

public class OrderFindByIdControllerPresenter implements OrderFindByIdPresenter{

   private final OrderFindByIdUseCase orderFindByIdUseCase;

   public OrderFindByIdControllerPresenter(OrderFindByIdUseCase orderFindByIdUseCase) {
      this.orderFindByIdUseCase = orderFindByIdUseCase;
   }

   public OrderResponseFull execute(UUID orderId) {
      return new OrderResponseFull(orderFindByIdUseCase.execute(orderId));
   }
}