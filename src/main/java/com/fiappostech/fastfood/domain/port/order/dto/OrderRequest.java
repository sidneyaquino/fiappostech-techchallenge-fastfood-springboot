package com.fiappostech.fastfood.domain.port.order.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fiappostech.fastfood.domain.entity.OrderTracking;
import com.fiappostech.fastfood.domain.port.customer.dto.CustomerRequest;

public record OrderRequest(
      UUID orderId,
      CustomerRequest customer,
      LocalDateTime created,
      LocalDateTime tracked,
      OrderTracking tracking,
      BigDecimal value,
      List<OrderProductRequest> products) {
   public OrderRequest(OrderResponse orderResponse){
      this(orderResponse.orderId(),
            orderResponse.customer() != null ? new CustomerRequest(orderResponse.customer()) : null,
            orderResponse.created(),
            orderResponse.tracked(),
            orderResponse.tracking(),
            orderResponse.value(),
            null);
   }
}