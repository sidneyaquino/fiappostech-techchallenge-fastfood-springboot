package com.fiappostech.fastfood.application.usecase.payment;

import java.util.UUID;

import com.fiappostech.fastfood.application.port.payment.PaymentFindByOrderIdGateway;
import com.fiappostech.fastfood.domain.entity.PaymentDomain;
import com.fiappostech.fastfood.domain.port.payment.PaymentFindByOrderIdUseCase;
import com.fiappostech.fastfood.domain.port.payment.dto.PaymentResponse;

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
      var paymentResponse = this.paymentFindByOrderIdGateway.execute(orderId);
      var paymentDomain = new PaymentDomain(paymentResponse);
      //
      // Business Rules before Response.
      //

      return paymentDomain.toPaymentResponse();
   }
}