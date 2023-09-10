package com.fiappostech.fastfood.adapter.presenter.customer.response;

import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.customer.CustomerResponse;

public record CustomerResponseTracking(
      UUID customerId,
      String name) {
   public CustomerResponseTracking(CustomerResponse customerResponse) {
      this(customerResponse.customerId(),
            customerResponse.name());
   }

   public CustomerResponseTracking toCustomerResponseTracking() {
      return new CustomerResponseTracking(
            this.customerId(),
            this.name());
   }
}