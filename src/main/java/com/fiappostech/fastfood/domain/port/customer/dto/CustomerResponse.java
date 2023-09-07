package com.fiappostech.fastfood.domain.port.customer.dto;

import java.util.UUID;

public record CustomerResponse(
      UUID customerId,
      String personalId,
      String email,
      String name) {
}