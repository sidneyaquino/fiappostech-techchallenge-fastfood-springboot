package com.fiappostech.fastfood.adapter.presenter.order.request;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fiappostech.fastfood.domain.dto.order.OrderProductRequest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record OrderProdutcPostRequest(

      @NotBlank(message = "Product ID is mandatory.") 
      @JsonAlias("id") 
      UUID productId,

      @Min(value = 1) 
      @NotBlank(message = "Quantity is mandatory.") 
      Short quantity) {

   public OrderProductRequest toOrderProductRequest() {
      return new OrderProductRequest(
            this.productId(),
            this.quantity(),
            null);
   }
}