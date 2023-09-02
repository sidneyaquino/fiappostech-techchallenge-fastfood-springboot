package com.fiappostech.fastfood.application.ports.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.OrderTracking;

public record OrderRequest(
      UUID orderId,
      CustomerRequest customer,
      LocalDateTime created,
      LocalDateTime tracked,
      OrderTracking tracking,
      BigDecimal value,
      List<OrderProductRequest> products) {
}