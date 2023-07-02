package com.fiappostech.fastfood.adapters.inbound.response;

import com.fiappostech.fastfood.application.ports.dto.Customer;

public record CustomerResponse(String personalId, String name, String email) {
   public CustomerResponse(Customer customer){
      this(customer.personalId(), customer.name(), customer.email());
   }

   public Customer toCustomer() {
      return new Customer(this.personalId(), this.name, this.email);
   }
}