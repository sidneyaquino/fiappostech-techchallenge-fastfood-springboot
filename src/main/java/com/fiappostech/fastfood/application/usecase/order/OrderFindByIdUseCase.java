package com.fiappostech.fastfood.application.usecase.order;

import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.order.OrderResponse;

public interface OrderFindByIdUseCase {
   OrderResponse execute(UUID orderId);
}