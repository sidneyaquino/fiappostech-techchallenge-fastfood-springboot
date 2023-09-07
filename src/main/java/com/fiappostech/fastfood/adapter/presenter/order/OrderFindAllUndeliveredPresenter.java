package com.fiappostech.fastfood.adapter.presenter.order;

import java.util.List;

import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;
import com.fiappostech.fastfood.domain.port.order.OrderFindAllUndeliveredUseCase;
import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;

public class OrderFindAllUndeliveredPresenter {

   private final OrderFindAllUndeliveredUseCase orderFindAllUndeliveredUseCase;

   public OrderFindAllUndeliveredPresenter(OrderFindAllUndeliveredUseCase orderFindAllUndeliveredUseCase) {
      this.orderFindAllUndeliveredUseCase = orderFindAllUndeliveredUseCase;
   }

   public List<OrderResponseTracking> execute() {
      List<OrderResponse> listOrderResponse = orderFindAllUndeliveredUseCase.execute();
      return listOrderResponse.stream().map(item -> new OrderResponseTracking(item)).toList();
   }
}