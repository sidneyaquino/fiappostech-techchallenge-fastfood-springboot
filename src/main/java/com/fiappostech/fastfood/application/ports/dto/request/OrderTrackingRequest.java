package com.fiappostech.fastfood.application.ports.dto.request;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.Tracking;

public record OrderTrackingRequest(
      UUID orderId,
      Tracking tracking) {
}