package com.fiappostech.fastfood.application.ports.inbound;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.response.PaymentResponse;

public interface PaymentFindByOrderIdInputPort {
   PaymentResponse execute(UUID orderId);
}