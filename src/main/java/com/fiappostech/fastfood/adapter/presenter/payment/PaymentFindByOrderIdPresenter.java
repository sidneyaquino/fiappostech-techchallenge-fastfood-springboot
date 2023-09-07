package com.fiappostech.fastfood.adapter.presenter.payment;

import java.util.UUID;

import com.fiappostech.fastfood.adapter.presenter.payment.response.PaymentResponseFull;
import com.fiappostech.fastfood.domain.port.payment.PaymentFindByOrderIdUseCase;

public class PaymentFindByOrderIdPresenter {

   private final PaymentFindByOrderIdUseCase paymentFindByOrderIdUseCase;

   public PaymentFindByOrderIdPresenter(PaymentFindByOrderIdUseCase paymentFindByOrderIdUseCase) {
      this.paymentFindByOrderIdUseCase = paymentFindByOrderIdUseCase;
   }

   public PaymentResponseFull execute(UUID orderId) {
      return new PaymentResponseFull(paymentFindByOrderIdUseCase.execute(orderId));
   }
}