package com.fiappostech.fastfood.application.port.order;

import java.util.UUID;

import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;

public interface OrderFindByIdGateway {
   public OrderResponse execute(UUID orderId);
}
