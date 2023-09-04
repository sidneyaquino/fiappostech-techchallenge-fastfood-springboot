package com.fiappostech.fastfood.application.ports.outbound;

import com.fiappostech.fastfood.application.ports.dto.request.PaymentRequest;
import com.fiappostech.fastfood.application.ports.dto.response.PaymentResponse;

public interface PaymentInsertOutputPort {
   PaymentResponse execute(PaymentRequest paymentRequest);
}