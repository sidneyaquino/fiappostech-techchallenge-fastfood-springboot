package com.fiappostech.fastfood.domain.port.payment.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.domain.entity.PaymentStatus;
import com.fiappostech.fastfood.domain.port.order.dto.OrderRequest;

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