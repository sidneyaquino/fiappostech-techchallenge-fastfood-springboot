package com.fiappostech.fastfood.application.usecase.payment;

import java.util.UUID;

import com.fiappostech.fastfood.adapter.gateway.payment.PaymentFindByOrderIdGateway;
import com.fiappostech.fastfood.domain.dto.payment.PaymentResponse;
import com.fiappostech.fastfood.domain.entity.PaymentDomain;

public class PaymentFindByOrderIdInteractor implements PaymentFindByOrderIdUseCase {

   private final PaymentFindByOrderIdGateway paymentFindByOrderIdGateway;

   public PaymentFindByOrderIdInteractor(PaymentFindByOrderIdGateway paymentFindByOrderIdGateway) {
      this.paymentFindByOrderIdGateway = paymentFindByOrderIdGateway;
   }

   @Override
   public PaymentResponse execute(UUID orderId) {

      //
      // Business Rules before Request.
      //

      //
      // Request.
      //      
      var paymentResponse = this.paymentFindByOrderIdGateway.execute(orderId);
      var paymentDomain = new PaymentDomain(paymentResponse);
      
      //
      // Business Rules before Response.
      //

      return paymentDomain.toPaymentResponse();
   }
}