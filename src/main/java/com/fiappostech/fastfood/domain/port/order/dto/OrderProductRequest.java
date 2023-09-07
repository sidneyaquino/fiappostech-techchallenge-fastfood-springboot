package com.fiappostech.fastfood.domain.port.order.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderProductRequest(
      UUID productId,
      Short quantity,
      BigDecimal value) {
}