package com.fiappostech.fastfood.adapters.inbound.dto.request;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fiappostech.fastfood.application.ports.dto.request.CustomerRequest;
import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record OrderPostRequest(

      @Pattern(regexp = "^[0-9]+$", message = "Personal ID should only have numbers") 
      @Size(min = 11, max = 11, message = "Personal ID should be exactly 11 digits") @JsonAlias("id") 
      String personalId,

      @DecimalMin(value = "0.01") 
      @NotNull(message = "Value is mandatory.") 
      BigDecimal value,

      @NotEmpty(message = "Input products list cannot be empty") 
      List<OrderProdutcPostRequest> products) {    // PENDENCIA! @Valid Verificar como colocar Beanvalidator

   public OrderRequest toOrderRequest() {
      var listOrderProductRequest = products.stream().map(item -> item.toOrderProductRequest()).toList();

      return new OrderRequest(
            null,
            this.personalId() == null ? null
                  : new CustomerRequest(
                        null, this.personalId(), null, null),
            null,
            null,
            null,
            this.value(),
            listOrderProductRequest);
   }
}