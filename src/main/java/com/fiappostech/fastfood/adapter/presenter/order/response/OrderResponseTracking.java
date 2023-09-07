package com.fiappostech.fastfood.adapter.presenter.order.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.adapter.presenter.customer.response.CustomerResponseTracking;
import com.fiappostech.fastfood.domain.entity.OrderTracking;
import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;

public record OrderResponseTracking(
      UUID orderId,
      CustomerResponseTracking customer,
      LocalDateTime created,
      LocalDateTime tracked,
      OrderTracking tracking,
      Long queueTime) {
   public OrderResponseTracking(OrderResponse orderResponse) {
      this(orderResponse.orderId(),
            orderResponse.customer() == null ? null : new CustomerResponseTracking(orderResponse.customer()),
            orderResponse.created(),
            orderResponse.tracked(),
            orderResponse.tracking(),
            orderResponse.queueTime());
   }
}