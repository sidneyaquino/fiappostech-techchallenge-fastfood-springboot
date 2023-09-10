package com.fiappostech.fastfood.adapter.presenter.order.request;

import java.util.List;

import com.fiappostech.fastfood.domain.dto.customer.CustomerRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderRequest;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record OrderPostRequest(

      @Pattern(regexp = "^[0-9]+$", message = "Personal ID should only have numbers") 
      @Size(min = 11, max = 11, message = "Personal ID should be exactly 11 digits") 
      // @JsonAlias("id") 
      String personalId,

      @NotEmpty(message = "Input products list cannot be empty") 
      List<OrderProdutcPostRequest> products) {    // PENDENCY! @Valid OrderProdutcPostRequest =/

   public OrderRequest toOrderRequest() {
      var listOrderProductRequest = products.stream().map(item -> item.toOrderProductRequest()).toList();

      return new OrderRequest(
            null,
            this.personalId() == null ? null : new CustomerRequest(null, this.personalId(), null, null),
            null,
            null,
            null,
            null,
            listOrderProductRequest);
   }
}