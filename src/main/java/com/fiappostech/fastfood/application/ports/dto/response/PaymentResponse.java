package com.fiappostech.fastfood.application.ports.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.adapters.outbound.projection.PaymentProjection;
import com.fiappostech.fastfood.application.ports.dto.PaymentStatus;

public record PaymentResponse(
      UUID paymentId,
      UUID externalReference,
      OrderResponse order,
      LocalDateTime created,
      Boolean approved,
      PaymentStatus status,
      String detail,
      BigDecimal value) {
   public PaymentResponse(PaymentProjection paymenttProjection){
      this(paymenttProjection.getPaymentId(),
            null,
            null,
            paymenttProjection.getCreated(),
            paymenttProjection.getApproved(),
            paymenttProjection.getStatus(),
            paymenttProjection.getStatusDetail(),
            paymenttProjection.getValue());
   }            
}