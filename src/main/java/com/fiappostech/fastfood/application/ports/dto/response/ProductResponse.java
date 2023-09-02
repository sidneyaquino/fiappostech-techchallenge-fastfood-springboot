package com.fiappostech.fastfood.application.ports.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.ProductCategory;

public record ProductResponse(
      UUID productId,
      String name,
      String description,
      ProductCategory category,
      BigDecimal value) {
}