package com.fiappostech.fastfood.domain.port.payment;

import java.util.UUID;

import com.fiappostech.fastfood.domain.port.payment.dto.PaymentResponse;

public interface PaymentFindByOrderIdUseCase {
   PaymentResponse execute(UUID orderId);
}