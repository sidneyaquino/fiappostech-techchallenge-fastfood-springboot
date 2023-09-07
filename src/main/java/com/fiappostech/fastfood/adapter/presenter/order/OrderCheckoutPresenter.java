package com.fiappostech.fastfood.adapter.presenter.order;

import com.fiappostech.fastfood.adapter.presenter.order.request.OrderCheckoutPutRequest;
import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;
import com.fiappostech.fastfood.domain.port.order.OrderCheckoutUseCase;

public class OrderCheckoutPresenter {

   private final OrderCheckoutUseCase orderCheckoutUseCase;

   public OrderCheckoutPresenter(OrderCheckoutUseCase orderCheckoutUseCase) {
      this.orderCheckoutUseCase = orderCheckoutUseCase;
   }

   public OrderResponseTracking execute(OrderCheckoutPutRequest orderCheckoutPutRequest) {
      var orderCheckoutRequest = orderCheckoutPutRequest.toOrderRequest();
      return new OrderResponseTracking(orderCheckoutUseCase.execute(orderCheckoutRequest));
   }
}