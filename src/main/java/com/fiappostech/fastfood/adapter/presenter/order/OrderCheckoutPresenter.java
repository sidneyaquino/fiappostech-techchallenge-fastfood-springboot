package com.fiappostech.fastfood.adapter.presenter.order;

import com.fiappostech.fastfood.adapter.presenter.order.request.OrderCheckoutPutRequest;
import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;

public interface OrderCheckoutPresenter {
   public OrderResponseTracking execute(OrderCheckoutPutRequest orderCheckoutPutRequest);
}