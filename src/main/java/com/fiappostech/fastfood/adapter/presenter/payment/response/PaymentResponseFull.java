package com.fiappostech.fastfood.adapter.presenter.payment.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;
import com.fiappostech.fastfood.domain.dto.payment.PaymentResponse;
import com.fiappostech.fastfood.domain.entity.PaymentStatus;

public record PaymentResponseFull(
      UUID paymentId,
      UUID externalReference,
      OrderResponseTracking order,
      LocalDateTime created,
      Boolean approved,
      PaymentStatus status,
      String detail,
      BigDecimal value) {
   public PaymentResponseFull(PaymentResponse paymentResponse) {
      this(paymentResponse.paymentId(),
            paymentResponse.externalReference(),
            paymentResponse.order() == null ? null : new OrderResponseTracking(paymentResponse.order()),
            paymentResponse.created(),
            paymentResponse.approved(),
            paymentResponse.status(),
            paymentResponse.detail(),
            paymentResponse.value());
   }
}