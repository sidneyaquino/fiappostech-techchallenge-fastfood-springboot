package com.fiappostech.fastfood.application.ports.inbound;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;

public interface OrderFindByIdInputPort {
   OrderResponse execute(UUID orderId);
}