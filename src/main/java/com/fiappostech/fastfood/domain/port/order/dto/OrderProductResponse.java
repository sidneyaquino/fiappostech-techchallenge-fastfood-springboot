package com.fiappostech.fastfood.domain.port.order.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderProductResponse(
      UUID productId,
      String description,
      Short quantity,
      BigDecimal value) {
   // public OrderProductResponse(OrderProductProjection orderProductProjection){   // PENDENCY
   //    this(orderProductProjection.getProductId(),
   //          orderProductProjection.getDescription(),
   //          orderProductProjection.getQuantity(),
   //          orderProductProjection.getValue());
   // }
}