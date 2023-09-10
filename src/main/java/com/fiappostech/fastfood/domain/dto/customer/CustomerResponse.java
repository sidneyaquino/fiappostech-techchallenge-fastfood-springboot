package com.fiappostech.fastfood.domain.dto.customer;

import java.util.UUID;

public record CustomerResponse(
      UUID customerId,
      String personalId,
      String email,
      String name) {
}