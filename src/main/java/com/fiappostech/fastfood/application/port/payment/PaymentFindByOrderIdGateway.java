package com.fiappostech.fastfood.application.port.payment;

import java.util.UUID;

import com.fiappostech.fastfood.domain.port.payment.dto.PaymentResponse;

public interface PaymentFindByOrderIdGateway {
   PaymentResponse execute(UUID orderId);
}