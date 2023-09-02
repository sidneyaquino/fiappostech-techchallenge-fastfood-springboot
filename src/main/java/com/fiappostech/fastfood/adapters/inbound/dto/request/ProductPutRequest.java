package com.fiappostech.fastfood.adapters.inbound.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fiappostech.fastfood.application.ports.dto.ProductCategory;
import com.fiappostech.fastfood.application.ports.dto.request.ProductRequest;

import jakarta.validation.constraints.NotNull;

public record ProductPutRequest(

      @NotNull(message = "ProductId is mandatory.")
      @JsonAlias("id")
      UUID productId,
      
      String name,
      String description,
      ProductCategory category,
      BigDecimal value) {

   public ProductRequest toProductRequest() {
      return new ProductRequest(
            this.productId(),
            this.name(),
            this.description,
            this.category(),
            this.value());
   }
}