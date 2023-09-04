package com.fiappostech.fastfood.adapters.inbound.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.PaymentStatus;
import com.fiappostech.fastfood.application.ports.dto.response.PaymentResponse;

public record PaymentOrderResponse(
      UUID paymentId,
      LocalDateTime created,
      Boolean approved,
      PaymentStatus status,
      String detail,
      BigDecimal value) {
   public PaymentOrderResponse(PaymentResponse paymentResponse) {
      this(paymentResponse.paymentId(),
            paymentResponse.created(),
            paymentResponse.approved(),
            paymentResponse.status(),
            paymentResponse.detail(),
            paymentResponse.value());
   }
}