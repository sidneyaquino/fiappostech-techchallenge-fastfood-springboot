package com.fiappostech.fastfood.application.port.order;

import com.fiappostech.fastfood.domain.port.order.dto.OrderRequest;
import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;

public interface OrderInsertGateway {
   OrderResponse execute(OrderRequest orderRequest);
}