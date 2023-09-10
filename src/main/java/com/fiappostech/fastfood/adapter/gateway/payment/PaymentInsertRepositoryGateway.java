package com.fiappostech.fastfood.adapter.gateway.payment;

import com.fiappostech.fastfood.domain.dto.payment.PaymentRequest;
import com.fiappostech.fastfood.domain.dto.payment.PaymentResponse;
import com.fiappostech.fastfood.infrastructure.persistence.payment.PaymentInsertRepository;

public class PaymentInsertRepositoryGateway implements PaymentInsertGateway {

   private final PaymentInsertRepository paymentInsertRepository;

   public PaymentInsertRepositoryGateway(PaymentInsertRepository paymentInsertRepository) {
      this.paymentInsertRepository = paymentInsertRepository;
   }

   @Override
   public PaymentResponse execute(PaymentRequest paymentRequest) {
      return paymentInsertRepository.execute(paymentRequest);
   }
}