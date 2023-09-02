package com.fiappostech.fastfood.application.ports.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.ProductCategory;

public record ProductRequest(
      UUID productId,
      String name,
      String description,
      ProductCategory category,
      BigDecimal value) {
}