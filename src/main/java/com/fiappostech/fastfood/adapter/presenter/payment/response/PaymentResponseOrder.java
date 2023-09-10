package com.fiappostech.fastfood.adapter.presenter.payment.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.payment.PaymentResponse;
import com.fiappostech.fastfood.domain.entity.PaymentStatus;

public record PaymentResponseOrder(
      UUID paymentId,
      LocalDateTime created,
      Boolean approved,
      PaymentStatus status,
      String detail,
      BigDecimal value) {
   public PaymentResponseOrder(PaymentResponse paymentResponse) {
      this(paymentResponse.paymentId(),
            paymentResponse.created(),
            paymentResponse.approved(),
            paymentResponse.status(),
            paymentResponse.detail(),
            paymentResponse.value());
   }
}