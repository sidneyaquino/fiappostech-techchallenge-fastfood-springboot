package com.fiappostech.fastfood.application.port.payment;

import com.fiappostech.fastfood.domain.port.payment.dto.PaymentRequest;
import com.fiappostech.fastfood.domain.port.payment.dto.PaymentResponse;

public interface PaymentInsertGateway {
   PaymentResponse execute(PaymentRequest paymentRequest);
}