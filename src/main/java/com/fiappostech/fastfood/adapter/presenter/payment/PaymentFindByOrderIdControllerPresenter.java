package com.fiappostech.fastfood.adapter.presenter.payment;

import java.util.UUID;

import com.fiappostech.fastfood.adapter.presenter.payment.response.PaymentResponseFull;
import com.fiappostech.fastfood.application.usecase.payment.PaymentFindByOrderIdUseCase;

public class PaymentFindByOrderIdControllerPresenter implements PaymentFindByOrderIdPresenter{

   private final PaymentFindByOrderIdUseCase paymentFindByOrderIdUseCase;

   public PaymentFindByOrderIdControllerPresenter(PaymentFindByOrderIdUseCase paymentFindByOrderIdUseCase) {
      this.paymentFindByOrderIdUseCase = paymentFindByOrderIdUseCase;
   }

   public PaymentResponseFull execute(UUID orderId) {
      return new PaymentResponseFull(paymentFindByOrderIdUseCase.execute(orderId));
   }
}