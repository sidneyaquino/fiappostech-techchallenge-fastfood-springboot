package com.fiappostech.fastfood.application.ports.outbound;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.response.PaymentResponse;

public interface PaymentFindByOrderIdOutputPort {
   PaymentResponse execute(UUID orderId);
}