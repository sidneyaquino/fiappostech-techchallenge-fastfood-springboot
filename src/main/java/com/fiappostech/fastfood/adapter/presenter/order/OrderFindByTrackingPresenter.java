package com.fiappostech.fastfood.adapter.presenter.order;

import java.util.List;

import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;
import com.fiappostech.fastfood.domain.entity.OrderTracking;

public interface OrderFindByTrackingPresenter {
   public List<OrderResponseTracking> execute(OrderTracking tracking);
}