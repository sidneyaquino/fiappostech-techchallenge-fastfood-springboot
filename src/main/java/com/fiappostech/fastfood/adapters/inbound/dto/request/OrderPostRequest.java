package com.fiappostech.fastfood.adapters.inbound.dto.request;

import java.math.BigDecimal;

import com.fiappostech.fastfood.application.ports.dto.request.CustomerRequest;
import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record OrderPostRequest(

      @Pattern(regexp = "^[0-9]+$", message = "Personal ID should only have numbers") 
      @Size(min = 11, max = 11, message = "Personal ID should be exactly 11 digits") 
      String personalId,

      @DecimalMin(value = "0.01") 
      @NotNull(message = "Value is mandatory.") 
      BigDecimal value) {

   public OrderRequest toOrderRequest() {
      return new OrderRequest(
            null,
            this.personalId() == null ? null
                  : new CustomerRequest(
                        null, this.personalId(), null, null),
            null,
            null,
            null,
            this.value());
   }
}