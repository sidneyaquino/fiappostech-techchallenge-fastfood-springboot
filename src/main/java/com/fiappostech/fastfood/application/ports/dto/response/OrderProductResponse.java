package com.fiappostech.fastfood.application.ports.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.adapters.outbound.projection.OrderProductProjection;

public record OrderProductResponse(
      UUID productId,
      String description,
      Short quantity,
      BigDecimal value) {
   public OrderProductResponse(OrderProductProjection orderProductProjection){
      this(orderProductProjection.getProductId(),
            orderProductProjection.getDescription(),
            orderProductProjection.getQuantity(),
            orderProductProjection.getValue());
   }
}