package com.fiappostech.fastfood.domain.dto.payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.domain.entity.PaymentStatus;

public record PaymentResponse(
      UUID paymentId,
      UUID externalReference,
      OrderResponse order,
      LocalDateTime created,
      Boolean approved,
      PaymentStatus status,
      String detail,
      BigDecimal value) {
}