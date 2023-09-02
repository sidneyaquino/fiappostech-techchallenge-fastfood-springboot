package com.fiappostech.fastfood.application.ports.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.OrderTracking;

public record OrderResponse(
      UUID orderId,
      CustomerResponse customer,
      LocalDateTime created,
      LocalDateTime tracked,
      OrderTracking tracking,
      Long queueTime,
      BigDecimal value, 
      List<OrderProductResponse> products) {
}