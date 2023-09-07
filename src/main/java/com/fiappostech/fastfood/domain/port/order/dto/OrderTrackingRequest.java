package com.fiappostech.fastfood.domain.port.order.dto;

import java.util.UUID;

import com.fiappostech.fastfood.domain.entity.OrderTracking;

public record OrderTrackingRequest(
      UUID orderId,
      OrderTracking tracking) {
}