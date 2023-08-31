package com.fiappostech.fastfood.adapters.inbound.dto.request;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record OrderCheckoutPutRequest(

      @NotNull(message = "OrderId is mandatory.")
      @JsonAlias("id")
      UUID orderId,

      @NotEmpty(message = "Input products list cannot be empty") 
      List<OrderProdutcPostRequest> products) {    // PENDENCY! @Valid OrderProdutcPostRequest =/

   public OrderRequest toOrderRequest() {
      var listOrderProductRequest = products.stream().map(item -> item.toOrderProductRequest()).toList();

      return new OrderRequest(
            orderId,
            null,
            null,
            null,
            null,
            null,
            listOrderProductRequest);
   }
}