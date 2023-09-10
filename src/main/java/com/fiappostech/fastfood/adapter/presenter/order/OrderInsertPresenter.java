package com.fiappostech.fastfood.adapter.presenter.order;

import com.fiappostech.fastfood.adapter.presenter.order.request.OrderPostRequest;
import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseFull;

public interface OrderInsertPresenter {
   public OrderResponseFull execute(OrderPostRequest orderPostRequest);
}