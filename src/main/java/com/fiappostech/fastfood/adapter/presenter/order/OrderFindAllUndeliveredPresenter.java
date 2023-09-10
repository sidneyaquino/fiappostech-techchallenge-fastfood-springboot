package com.fiappostech.fastfood.adapter.presenter.order;

import java.util.List;

import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;

public interface OrderFindAllUndeliveredPresenter {
   public List<OrderResponseTracking> execute();
}