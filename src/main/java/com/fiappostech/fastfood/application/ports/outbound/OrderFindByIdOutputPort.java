package com.fiappostech.fastfood.application.ports.outbound;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;

public interface OrderFindByIdOutputPort {
   public OrderResponse execute(UUID orderId);
}
