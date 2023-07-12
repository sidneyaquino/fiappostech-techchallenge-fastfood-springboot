package com.fiappostech.fastfood.adapters.inbound.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.response.OrderProductResponse;

public record OrderProductFullResponse(
      UUID productId,
      String description,
      Short quantity,
      BigDecimal value) {
   public OrderProductFullResponse(OrderProductResponse orderProductResponse) {
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