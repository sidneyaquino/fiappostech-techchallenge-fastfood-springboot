package com.fiappostech.fastfood.application.core.usecases;

import java.util.UUID;

import com.fiappostech.fastfood.application.core.domain.PaymentDomain;
import com.fiappostech.fastfood.application.ports.dto.response.PaymentResponse;
import com.fiappostech.fastfood.application.ports.inbound.PaymentFindByOrderIdInputPort;
import com.fiappostech.fastfood.application.ports.outbound.PaymentFindByOrderIdOutputPort;

public class PaymentFindByOrderIdService implements PaymentFindByOrderIdInputPort {

   private final PaymentFindByOrderIdOutputPort paymentFindByOrderIdOutputPort;

   public PaymentFindByOrderIdService(PaymentFindByOrderIdOutputPort paymentFindByOrderIdOutputPort) {
      this.paymentFindByOrderIdOutputPort = paymentFindByOrderIdOutputPort;
   }

   @Override
   public PaymentResponse execute(UUID orderId) {

      //
      // Business Rules before Request.
      //
      var paymentResponse = this.paymentFindByOrderIdOutputPort.execute(orderId);
      var paymentDomain = new PaymentDomain(paymentResponse);
      //
      // Business Rules before Response.
      //

      return paymentDomain.toPaymentResponse();
   }
}