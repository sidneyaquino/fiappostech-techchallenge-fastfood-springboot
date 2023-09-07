package com.fiappostech.fastfood.domain.port.payment.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.domain.entity.PaymentStatus;
import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;

public record PaymentResponse(
      UUID paymentId,
      UUID externalReference,
      OrderResponse order,
      LocalDateTime created,
      Boolean approved,
      PaymentStatus status,
      String detail,
      BigDecimal value) {
   // public PaymentResponse(PaymentProjection paymenttProjection){  // PENDENCY
   //    this(paymenttProjection.getPaymentId(),
   //          null,
   //          null,
   //          paymenttProjection.getCreated(),
   //          paymenttProjection.getApproved(),
   //          paymenttProjection.getStatus(),
   //          paymenttProjection.getStatusDetail(),
   //          paymenttProjection.getValue());
   // }
}