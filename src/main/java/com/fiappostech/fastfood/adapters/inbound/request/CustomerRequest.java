package com.fiappostech.fastfood.adapters.inbound.request;

import com.fiappostech.fastfood.application.ports.dto.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CustomerRequest(

      @Pattern(regexp = "^[0-9]+$")
      @Size(min = 11, max = 11, message = "Personal ID should be 11 digits")
      @NotBlank(message = "Personal ID is mandatory.") 
      String personalId,
      
      @Email(message = "Email should be valid")
      @NotBlank(message = "Email is mandatory.")
      String email,

      @NotBlank(message = "Name is mandatory.")
      String name) {

   public Customer toCustomer() {
      return new Customer(this.personalId(), this.email(), this.name());
   }
}