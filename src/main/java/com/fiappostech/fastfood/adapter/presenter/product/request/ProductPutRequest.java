package com.fiappostech.fastfood.adapter.presenter.product.request;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.domain.entity.ProductCategory;
import com.fiappostech.fastfood.domain.port.product.dto.ProductRequest;

import jakarta.validation.constraints.NotNull;

public record ProductPutRequest(

      @NotNull(message = "ProductId is mandatory.")
      // @JsonAlias("id")
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