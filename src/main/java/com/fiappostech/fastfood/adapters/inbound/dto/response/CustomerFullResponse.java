package com.fiappostech.fastfood.adapters.inbound.dto.response;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;

public record CustomerFullResponse(
      UUID customerId,
      String personalId,
      String name,
      String email) {
   public CustomerFullResponse(CustomerResponse customerResponse) {
      this(customerResponse.customerId(),
            customerResponse.personalId(),
            customerResponse.name(),
            customerResponse.email());
   }

   public CustomerResponse toCustomerResponse() {
      return new CustomerResponse(
            this.customerId(),
            this.personalId(),
            this.name(),
            this.email());
   }
}