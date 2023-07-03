package com.fiappostech.fastfood.adapters.inbound.dto.response;

import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;

public record CustomerResponseDTO(String personalId, String name, String email) {
   public CustomerResponseDTO(CustomerResponse customerResponse){
      this(customerResponse.personalId(), customerResponse.name(), customerResponse.email());
   }

   public CustomerResponse toCustomerResponse() {
      return new CustomerResponse(this.personalId(), this.name(), this.email());
   }
}