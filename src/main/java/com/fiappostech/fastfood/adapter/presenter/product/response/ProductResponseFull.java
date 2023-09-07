package com.fiappostech.fastfood.adapter.presenter.product.response;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.domain.entity.ProductCategory;
import com.fiappostech.fastfood.domain.port.product.dto.ProductResponse;

public record ProductResponseFull(
      UUID productId,
      String name,
      String description,
      ProductCategory category,
      BigDecimal value) {
   public ProductResponseFull(ProductResponse productResponse) {
      this(productResponse.productId(),
            productResponse.name(),
            productResponse.description(),
            productResponse.category(),
            productResponse.value());
   }

   public ProductResponse toProductResponse() {
      return new ProductResponse(
            this.productId(),
            this.name(),
            this.description(),
            this.category(),
            this.value());
   }
}