package com.fiappostech.fastfood.application.ports.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.Tracking;

public record OrderRequest(
      UUID orderId,
      CustomerRequest customer,
      LocalDateTime created,
      LocalDateTime tracked,
      Tracking tracking,
      BigDecimal value,
      List<OrderProductRequest> products) {
}