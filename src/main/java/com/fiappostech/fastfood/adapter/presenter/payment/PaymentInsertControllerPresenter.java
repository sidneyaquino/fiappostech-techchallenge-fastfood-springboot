package com.fiappostech.fastfood.adapter.presenter.payment;

import com.fiappostech.fastfood.adapter.presenter.payment.request.PaymentPostRequest;
import com.fiappostech.fastfood.adapter.presenter.payment.response.PaymentResponseFull;
import com.fiappostech.fastfood.application.usecase.payment.PaymentInsertUseCase;

public class PaymentInsertControllerPresenter implements PaymentInsertPresenter{

   private final PaymentInsertUseCase paymentInsertUseCase;

   public PaymentInsertControllerPresenter(PaymentInsertUseCase paymentInsertUseCase) {
      this.paymentInsertUseCase = paymentInsertUseCase;
   }

   public PaymentResponseFull execute(PaymentPostRequest paymentPostRequest) {
      return new PaymentResponseFull(paymentInsertUseCase.execute(paymentPostRequest.toPaymentRequest()));
   }
}