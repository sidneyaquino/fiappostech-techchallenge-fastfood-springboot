package com.fiappostech.fastfood.adapter.gateway.payment;

import com.fiappostech.fastfood.domain.dto.payment.PaymentRequest;
import com.fiappostech.fastfood.domain.dto.payment.PaymentResponse;

public interface PaymentInsertGateway {
   PaymentResponse execute(PaymentRequest paymentRequest);
}