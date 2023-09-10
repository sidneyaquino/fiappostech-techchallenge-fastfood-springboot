package com.fiappostech.fastfood.adapter.gateway.order;

import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.order.OrderResponse;

public interface OrderFindByIdGateway {
   public OrderResponse execute(UUID orderId);
}
