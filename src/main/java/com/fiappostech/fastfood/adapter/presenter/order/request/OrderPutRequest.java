package com.fiappostech.fastfood.adapter.presenter.order.request;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.entity.OrderTracking;

import jakarta.validation.constraints.NotNull;

public record OrderPutRequest(

      @NotNull(message = "OrderId is mandatory.")
      @JsonAlias("id")
      UUID orderId,

      @NotNull(message = "Tracking is mandatory.")
      OrderTracking tracking) {

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