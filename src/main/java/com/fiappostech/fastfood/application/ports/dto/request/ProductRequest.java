package com.fiappostech.fastfood.application.ports.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.Category;

public record ProductRequest(
      UUID productId,
      String name,
      String description,
      Category category,
      BigDecimal value) {
}