package com.fiappostech.fastfood.application.ports.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderProductRequest(
      UUID productId,
      Short quantity,
      BigDecimal value) {
}