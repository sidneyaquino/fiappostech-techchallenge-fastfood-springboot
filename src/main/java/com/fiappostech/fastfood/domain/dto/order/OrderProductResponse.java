package com.fiappostech.fastfood.domain.dto.order;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderProductResponse(
      UUID productId,
      String description,
      Short quantity,
      BigDecimal value) {
}