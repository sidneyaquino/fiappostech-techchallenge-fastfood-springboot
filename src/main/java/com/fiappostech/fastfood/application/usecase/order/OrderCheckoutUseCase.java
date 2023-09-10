package com.fiappostech.fastfood.application.usecase.order;

import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;

public interface OrderCheckoutUseCase {
   OrderResponse execute(OrderRequest orderRequest);
}