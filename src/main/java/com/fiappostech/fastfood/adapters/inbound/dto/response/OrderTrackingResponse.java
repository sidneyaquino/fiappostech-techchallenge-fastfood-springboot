package com.fiappostech.fastfood.adapters.inbound.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.Tracking;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;

public record OrderTrackingResponse(
      UUID orderId,
      CustomerTrackingResponse customer,
      LocalDateTime created,
      LocalDateTime tracked,
      Tracking traking,
      Long trakingTime) {
   public OrderTrackingResponse(OrderResponse orderResponse) {
      this(orderResponse.orderId(),
            orderResponse.customer() == null ? null : new CustomerTrackingResponse(orderResponse.customer()),
            orderResponse.created(),
            orderResponse.tracked(),
            orderResponse.tracking(),
            orderResponse.trackingTime());
   }
}