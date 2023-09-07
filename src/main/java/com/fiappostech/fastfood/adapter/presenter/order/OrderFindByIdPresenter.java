package com.fiappostech.fastfood.adapter.presenter.order;

import java.util.UUID;

import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseFull;
import com.fiappostech.fastfood.domain.port.order.OrderFindByIdUseCase;

public class OrderFindByIdPresenter {

   private final OrderFindByIdUseCase orderFindByIdUseCase;

   public OrderFindByIdPresenter(OrderFindByIdUseCase orderFindByIdUseCase) {
      this.orderFindByIdUseCase = orderFindByIdUseCase;
   }

   public OrderResponseFull execute(UUID orderId) {
      return new OrderResponseFull(orderFindByIdUseCase.execute(orderId));
   }
}