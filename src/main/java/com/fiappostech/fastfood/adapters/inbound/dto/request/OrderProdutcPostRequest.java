package com.fiappostech.fastfood.adapters.inbound.dto.request;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fiappostech.fastfood.application.ports.dto.request.OrderProductRequest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record OrderProdutcPostRequest(

      @NotBlank(message = "Product ID is mandatory.") 
      @JsonAlias("id") 
      UUID produtcId,

      @Min(value = 1) 
      @NotBlank(message = "Quantity is mandatory.") 
      Short quantity) {

   public OrderProductRequest toOrderProductRequest() {
      return new OrderProductRequest(
            null,
            this.produtcId(),
            this.quantity(),
            null);
   }
}