package com.fiappostech.fastfood.application.usecase.payment;

import com.fiappostech.fastfood.domain.dto.payment.PaymentRequest;
import com.fiappostech.fastfood.domain.dto.payment.PaymentResponse;

public interface PaymentInsertUseCase {
   PaymentResponse execute(PaymentRequest paymentRequest);
}