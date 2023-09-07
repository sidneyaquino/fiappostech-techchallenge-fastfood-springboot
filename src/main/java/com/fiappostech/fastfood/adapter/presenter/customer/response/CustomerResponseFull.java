package com.fiappostech.fastfood.adapter.presenter.customer.response;

import java.util.UUID;

import com.fiappostech.fastfood.domain.port.customer.dto.CustomerResponse;

public record CustomerResponseFull(
      UUID customerId,
      String personalId,
      String name,
      String email) {
   public CustomerResponseFull(CustomerResponse customerResponse) {
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