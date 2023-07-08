package com.fiappostech.fastfood.adapters.inbound.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.Tracking;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;

public record OrderFullResponse(
      UUID orderId,
      CustomerFullResponse customer,
      LocalDateTime created,
      LocalDateTime tracked,
      Tracking traking,
      BigDecimal value) {
   public OrderFullResponse(OrderResponse orderResponse) {
      this(orderResponse.orderId(),
            orderResponse.customer() == null ? null : new CustomerFullResponse(orderResponse.customer()),
            orderResponse.created(),
            orderResponse.tracked(),
            orderResponse.tracking(),
            orderResponse.value());
   }

   public OrderResponse toOrderResponse() {
      return new OrderResponse(
            this.orderId(),
            this.customer() == null ? null : this.customer().toCustomerResponse(),
            this.created(),
            this.tracked(),
            this.traking(),
            this.value());
   }
}