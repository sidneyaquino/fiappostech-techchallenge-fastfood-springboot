package com.fiappostech.fastfood.adapter.presenter.payment;

import java.util.UUID;

import com.fiappostech.fastfood.adapter.presenter.payment.response.PaymentResponseFull;

public interface PaymentFindByOrderIdPresenter {
   public PaymentResponseFull execute(UUID orderId);
}