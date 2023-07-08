package com.fiappostech.fastfood.application.ports.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.Tracking;

public record OrderResponse(
      UUID orderId,
      CustomerResponse customer,
      LocalDateTime created,
      LocalDateTime tracked,
      Tracking tracking,
      BigDecimal value) {
}