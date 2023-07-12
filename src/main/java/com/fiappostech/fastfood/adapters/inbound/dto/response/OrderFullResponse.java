package com.fiappostech.fastfood.adapters.inbound.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.Tracking;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;

public record OrderFullResponse(
      UUID orderId,
      CustomerFullResponse customer,
      LocalDateTime created,
      LocalDateTime tracked,
      Tracking traking,
      Integer trakingTime,
      BigDecimal value,
      List<OrderProductFullResponse> products) {
   public OrderFullResponse(OrderResponse orderResponse) {
      this(orderResponse.orderId(),
            orderResponse.customer() == null ? null : new CustomerFullResponse(orderResponse.customer()),
            orderResponse.created(),
            orderResponse.tracked(),
            orderResponse.tracking(),
            orderResponse.trackingTime(),
            orderResponse.value(),
            orderResponse.products().stream().map(OrderProductFullResponse::new).toList());
   }

   public OrderResponse toOrderResponse() {
      return new OrderResponse(
            this.orderId(),
            this.customer() == null ? null : this.customer().toCustomerResponse(),
            this.created(),
            this.tracked(),
            this.traking(),
            this.trakingTime(),
            this.value(),
            this.products().stream().map(item -> item.toOrderProductResponse()).toList());
   }
}