package com.fiappostech.fastfood.adapter.presenter.customer.request;

import com.fiappostech.fastfood.domain.dto.customer.CustomerRequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CustomerPostRequest(

      @Pattern(regexp = "^[0-9]+$", message = "Personal ID should only have numbers")
      @Size(min = 11, max = 11, message = "Personal ID should be exactly 11 digits")
      @NotBlank(message = "Personal ID is mandatory.")
      // @JsonAlias("id")
      String personalId,

      // @Pattern(regexp = "^(.+)@(\\S+)$", message = "Email should be valid")
      @Email(message = "Email should be valid")
      @NotBlank(message = "Email is mandatory.")
      String email,

      @NotBlank(message = "Name is mandatory.")
      String name) {

   public CustomerRequest toCustomerRequest() {
      return new CustomerRequest(
            null,
            this.personalId(),
            this.email(),
            this.name());
   }
}