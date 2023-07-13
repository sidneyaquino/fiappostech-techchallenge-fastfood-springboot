package com.fiappostech.fastfood.application.ports.dto.request;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;

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