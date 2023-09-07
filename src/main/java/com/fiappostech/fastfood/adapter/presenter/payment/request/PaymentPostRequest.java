package com.fiappostech.fastfood.adapter.presenter.payment.request;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.domain.entity.PaymentStatus;
import com.fiappostech.fastfood.domain.port.order.dto.OrderRequest;
import com.fiappostech.fastfood.domain.port.payment.dto.PaymentRequest;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record PaymentPostRequest(   

      // @NotNull(message = "Id is mandatory.")
      UUID id,        // external_reference

      @NotNull(message = "External Reference is mandatory.")
      UUID external_reference,   // orderId

      @NotNull(message = "Status is mandatory")
      PaymentStatus status,

      String status_detail,

      @DecimalMin(value = "0.01")
      @NotNull(message = "Transaction Amount is mandatory.")
      BigDecimal transaction_amount) {

   public PaymentRequest toPaymentRequest() {
      return new PaymentRequest(
            null,
            id,
            external_reference == null ? null 
               : new OrderRequest(external_reference, null, null, null, null, null, null),
            null,
            null,
            status,
            status_detail,
            transaction_amount);
   }
}