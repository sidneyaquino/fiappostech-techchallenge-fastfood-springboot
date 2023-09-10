package com.fiappostech.fastfood.application.usecase.payment;

import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.payment.PaymentResponse;

public interface PaymentFindByOrderIdUseCase {
   PaymentResponse execute(UUID orderId);
}