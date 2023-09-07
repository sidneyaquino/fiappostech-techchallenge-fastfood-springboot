package com.fiappostech.fastfood.domain.port.product.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.domain.entity.ProductCategory;

public record ProductResponse(
      UUID productId,
      String name,
      String description,
      ProductCategory category,
      BigDecimal value) {
}