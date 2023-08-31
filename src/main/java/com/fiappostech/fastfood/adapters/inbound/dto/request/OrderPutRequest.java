package com.fiappostech.fastfood.adapters.inbound.dto.request;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fiappostech.fastfood.application.ports.dto.Tracking;
import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;

import jakarta.validation.constraints.NotNull;

public record OrderPutRequest(

      @NotNull(message = "OrderId is mandatory.")
      @JsonAlias("id")
      UUID orderId,

      @NotNull(message = "Tracking is mandatory.")
      Tracking tracking) {

   public OrderRequest toOrderRequest() {
      return new OrderRequest(
            this.orderId(),
            null,
            null,
            null,
            this.tracking(),
            null,
            null);
   }
}