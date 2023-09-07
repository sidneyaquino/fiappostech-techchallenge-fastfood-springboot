package com.fiappostech.fastfood.domain.port.order;

import java.util.UUID;

import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;

public interface OrderFindByIdUseCase {
   OrderResponse execute(UUID orderId);
}