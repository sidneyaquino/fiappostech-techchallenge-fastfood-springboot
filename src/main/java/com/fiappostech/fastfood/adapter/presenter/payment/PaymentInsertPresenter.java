package com.fiappostech.fastfood.adapter.presenter.payment;

import com.fiappostech.fastfood.adapter.presenter.payment.request.PaymentPostRequest;
import com.fiappostech.fastfood.adapter.presenter.payment.response.PaymentResponseFull;

public interface PaymentInsertPresenter {
   public PaymentResponseFull execute(PaymentPostRequest paymentPostRequest);
}