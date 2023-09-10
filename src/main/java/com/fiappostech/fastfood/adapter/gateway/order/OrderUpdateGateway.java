package com.fiappostech.fastfood.adapter.gateway.order;

import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;

public interface OrderUpdateGateway {
   OrderResponse execute(OrderRequest orderRequest);
}