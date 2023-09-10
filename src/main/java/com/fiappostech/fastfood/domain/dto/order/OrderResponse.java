package com.fiappostech.fastfood.domain.dto.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.customer.CustomerResponse;
import com.fiappostech.fastfood.domain.entity.OrderTracking;

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