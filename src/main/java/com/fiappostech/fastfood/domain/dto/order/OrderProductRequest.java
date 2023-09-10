package com.fiappostech.fastfood.domain.dto.order;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderProductRequest(
      UUID productId,
      Short quantity,
      BigDecimal value) {
}