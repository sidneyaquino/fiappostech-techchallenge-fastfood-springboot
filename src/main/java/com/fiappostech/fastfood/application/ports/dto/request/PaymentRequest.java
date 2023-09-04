package com.fiappostech.fastfood.application.ports.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.PaymentStatus;

public record PaymentRequest(
      UUID paymentId,
      UUID externalReference,
      OrderRequest order,
      LocalDateTime created,
      Boolean approved,
      PaymentStatus status,
      String detail,
      BigDecimal value) {
}