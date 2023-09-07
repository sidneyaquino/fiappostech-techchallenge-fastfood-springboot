package com.fiappostech.fastfood.domain.port.payment;

import com.fiappostech.fastfood.domain.port.payment.dto.PaymentRequest;
import com.fiappostech.fastfood.domain.port.payment.dto.PaymentResponse;

public interface PaymentInsertUseCase {
   PaymentResponse execute(PaymentRequest paymentRequest);
}