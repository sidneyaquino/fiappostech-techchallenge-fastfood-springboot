package com.fiappostech.fastfood.adapters.inbound.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.Category;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;

public record ProductResponseDTO(UUID productId, String name, String Description, Category category, BigDecimal value) {
   public ProductResponseDTO(ProductResponse productResponse){
      this(productResponse.productId(), productResponse.name(), productResponse.description(), productResponse.category(), productResponse.value());
   }

   public ProductResponse toProductResponse() {
      return new ProductResponse(this.productId(), this.name(), this.Description(), this.category(), this.value());
   }
}