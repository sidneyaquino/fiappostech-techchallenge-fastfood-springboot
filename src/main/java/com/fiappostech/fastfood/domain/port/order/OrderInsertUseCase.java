package com.fiappostech.fastfood.domain.port.order;

import com.fiappostech.fastfood.domain.port.order.dto.OrderRequest;
import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;

public interface OrderInsertUseCase {
   OrderResponse execute(OrderRequest orderRequest);
}