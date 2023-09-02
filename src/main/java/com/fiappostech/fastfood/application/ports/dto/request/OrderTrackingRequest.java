package com.fiappostech.fastfood.application.ports.dto.request;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.OrderTracking;

public record OrderTrackingRequest(
      UUID orderId,
      OrderTracking tracking) {
}