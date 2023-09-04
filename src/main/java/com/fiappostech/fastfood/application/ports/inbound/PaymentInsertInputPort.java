package com.fiappostech.fastfood.application.ports.inbound;

import com.fiappostech.fastfood.application.ports.dto.request.PaymentRequest;
import com.fiappostech.fastfood.application.ports.dto.response.PaymentResponse;

public interface PaymentInsertInputPort {
   PaymentResponse execute(PaymentRequest paymentRequest);
}