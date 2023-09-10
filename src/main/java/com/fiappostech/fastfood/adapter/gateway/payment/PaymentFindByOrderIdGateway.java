package com.fiappostech.fastfood.adapter.gateway.payment;

import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.payment.PaymentResponse;

public interface PaymentFindByOrderIdGateway {
   PaymentResponse execute(UUID orderId);
}