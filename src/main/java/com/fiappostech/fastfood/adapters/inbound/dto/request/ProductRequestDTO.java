package com.fiappostech.fastfood.adapters.inbound.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.Category;
import com.fiappostech.fastfood.application.ports.dto.request.ProductRequest;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequestDTO(

      UUID productId,

      @NotBlank(message = "Name is mandatory.") 
      String name,

      @NotBlank(message = "Description is mandatory.") 
      String description,

      // @NotBlank(message = "Category is mandatory.")
      Category category,

      @DecimalMin(value = "0.01")
      @NotNull(message = "Value is mandatory.") 
      BigDecimal value) {

   public ProductRequest toProductRequest() {
      return new ProductRequest(this.productId(), this.name(), this.description, this.category(), this.value());
   }
}
