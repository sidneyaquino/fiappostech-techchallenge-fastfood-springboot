package com.fiappostech.fastfood.adapters.inbound.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fiappostech.fastfood.application.ports.dto.request.OrderCheckoutRequest;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record OrderCheckoutPostRequest(

      @NotNull(message = "OrderId is mandatory.")
      @JsonAlias("id")
      UUID orderId,

      @DecimalMin(value = "0.01")
      @NotNull(message = "Value is mandatory.")
      BigDecimal value) {

   public OrderCheckoutRequest toOrderCheckoutRequest() {
      return new OrderCheckoutRequest(
            orderId,
            this.value());
   }
}