package com.fiappostech.fastfood.domain.port.customer.dto;

import java.util.UUID;

public record CustomerRequest(
      UUID customerId,
      String personalId,
      String email,
      String name) {
   public CustomerRequest(CustomerResponse customerResponse){
      this(customerResponse.customerId(),
            customerResponse.personalId(),
            customerResponse.email(),
            customerResponse.name());
   }
}