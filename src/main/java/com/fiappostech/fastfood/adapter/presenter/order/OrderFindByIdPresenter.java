package com.fiappostech.fastfood.adapter.presenter.order;

import java.util.UUID;

import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseFull;

public interface OrderFindByIdPresenter {
   public OrderResponseFull execute(UUID orderId);
}