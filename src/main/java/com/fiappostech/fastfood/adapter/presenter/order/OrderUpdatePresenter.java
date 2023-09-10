package com.fiappostech.fastfood.adapter.presenter.order;

import com.fiappostech.fastfood.adapter.presenter.order.request.OrderPutRequest;
import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;

public interface OrderUpdatePresenter {
   public OrderResponseTracking execute(OrderPutRequest orderPutRequest);
}