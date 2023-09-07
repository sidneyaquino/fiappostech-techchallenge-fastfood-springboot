package com.fiappostech.fastfood.adapter.presenter.product.request;

import java.math.BigDecimal;

import com.fiappostech.fastfood.domain.entity.ProductCategory;
import com.fiappostech.fastfood.domain.port.product.dto.ProductRequest;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductPostRequest(

      @NotBlank(message = "Name is mandatory.")
      String name,

      @NotBlank(message = "Description is mandatory.")
      String description,

      @NotNull(message = "Category is mandatory")
      ProductCategory category,

      @DecimalMin(value = "0.01")
      @NotNull(message = "Value is mandatory.")
      BigDecimal value) {

   public ProductRequest toProductRequest() {
      return new ProductRequest(
            null,
            this.name(),
            this.description,
            this.category(),
            this.value());
   }
}