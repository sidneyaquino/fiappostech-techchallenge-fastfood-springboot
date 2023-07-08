package com.fiappostech.fastfood.application.ports.dto.response;

import java.util.UUID;

public record CustomerResponse(
      UUID customerId,
      String personalId,
      String email,
      String name) {
}