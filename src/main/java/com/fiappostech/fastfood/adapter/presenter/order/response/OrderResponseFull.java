package com.fiappostech.fastfood.adapter.presenter.order.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fiappostech.fastfood.adapter.presenter.customer.response.CustomerResponseFull;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.domain.entity.OrderTracking;

public record OrderResponseFull(
      UUID orderId,
      CustomerResponseFull customer,
      LocalDateTime created,
      LocalDateTime tracked,
      OrderTracking tracking,
      Long queueTime,
      BigDecimal value,
      List<OrderProductResponseFull> products) {
   public OrderResponseFull(OrderResponse orderResponse) {
      this(orderResponse.orderId(),
            orderResponse.customer() == null ? null : new CustomerResponseFull(orderResponse.customer()),
            orderResponse.created(),
            orderResponse.tracked(),
            orderResponse.tracking(),
            orderResponse.queueTime(),
            orderResponse.value(),
            orderResponse.products().stream().map(OrderProductResponseFull::new).toList());
   }

   public OrderResponse toOrderResponse() {
      return new OrderResponse(
            this.orderId(),
            this.customer() == null ? null : this.customer().toCustomerResponse(),
            this.created(),
            this.tracked(),
            this.tracking(),
            this.queueTime(),
            this.value(),
            this.products().stream().map(item -> item.toOrderProductResponse()).toList());
   }
}