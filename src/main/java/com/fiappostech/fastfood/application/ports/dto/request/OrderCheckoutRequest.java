package com.fiappostech.fastfood.application.ports.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderCheckoutRequest(
      UUID orderId,
      BigDecimal value) {
}