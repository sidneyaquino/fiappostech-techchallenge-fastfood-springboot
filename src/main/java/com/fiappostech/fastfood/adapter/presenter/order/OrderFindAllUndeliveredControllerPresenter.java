package com.fiappostech.fastfood.adapter.presenter.order;

import java.util.List;

import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;
import com.fiappostech.fastfood.application.usecase.order.OrderFindAllUndeliveredUseCase;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;

public class OrderFindAllUndeliveredControllerPresenter implements OrderFindAllUndeliveredPresenter{

   private final OrderFindAllUndeliveredUseCase orderFindAllUndeliveredUseCase;

   public OrderFindAllUndeliveredControllerPresenter(OrderFindAllUndeliveredUseCase orderFindAllUndeliveredUseCase) {
      this.orderFindAllUndeliveredUseCase = orderFindAllUndeliveredUseCase;
   }

   public List<OrderResponseTracking> execute() {
      List<OrderResponse> listOrderResponse = orderFindAllUndeliveredUseCase.execute();
      return listOrderResponse.stream().map(item -> new OrderResponseTracking(item)).toList();
   }
}