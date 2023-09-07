package com.fiappostech.fastfood.adapter.presenter.order.response;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.domain.port.order.dto.OrderProductResponse;

public record OrderProductResponseFull(
      UUID productId,
      String description,
      Short quantity,
      BigDecimal value) {
   public OrderProductResponseFull(OrderProductResponse orderProductResponse) {
      this(orderProductResponse.productId(),
            orderProductResponse.description(),
            orderProductResponse.quantity(),
            orderProductResponse.value());
   }

   public OrderProductResponse toOrderProductResponse() {
      return new OrderProductResponse(
            this.productId(),
            this.description(),
            this.quantity(),
            this.value());
   }
}