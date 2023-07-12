package com.fiappostech.fastfood.adapters.inbound.dto.response;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;

public record CustomerTrackingResponse(
      UUID customerId,
      String name) {
   public CustomerTrackingResponse(CustomerResponse customerResponse) {
      this(customerResponse.customerId(),
            customerResponse.name());
   }
}