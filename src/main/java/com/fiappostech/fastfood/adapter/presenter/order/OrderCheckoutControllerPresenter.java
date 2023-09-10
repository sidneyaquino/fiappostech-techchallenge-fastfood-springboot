package com.fiappostech.fastfood.adapter.presenter.order;

import com.fiappostech.fastfood.adapter.presenter.order.request.OrderCheckoutPutRequest;
import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;
import com.fiappostech.fastfood.application.usecase.order.OrderCheckoutUseCase;

public class OrderCheckoutControllerPresenter implements OrderCheckoutPresenter {

   private final OrderCheckoutUseCase orderCheckoutUseCase;

   public OrderCheckoutControllerPresenter(OrderCheckoutUseCase orderCheckoutUseCase) {
      this.orderCheckoutUseCase = orderCheckoutUseCase;
   }

   public OrderResponseTracking execute(OrderCheckoutPutRequest orderCheckoutPutRequest) {
      var orderCheckoutRequest = orderCheckoutPutRequest.toOrderRequest();
      return new OrderResponseTracking(orderCheckoutUseCase.execute(orderCheckoutRequest));
   }
}