package com.fiappostech.fastfood.adapters.inbound.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.Category;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;

public record ProductFullResponse(
      UUID productId, 
      String name, 
      String description, 
      Category category,
      BigDecimal value) {
   public ProductFullResponse(ProductResponse productResponse) {
      this(productResponse.productId(), 
            productResponse.name(), 
            productResponse.description(),
            productResponse.category(), 
            productResponse.value());
   }

   public ProductResponse toProductResponse() {
      return new ProductResponse(this.productId(), this.name(), this.description(), this.category(), this.value());
   }
}