package com.fiappostech.fastfood.adapters.outbound.projection;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.PaymentStatus;

public interface PaymentProjection {
   UUID getPaymentId();
   UUID getOrderId();
   LocalDateTime getCreated();
   Boolean getApproved();
   PaymentStatus getStatus();
   String getStatusDetail();
   BigDecimal getValue();
}