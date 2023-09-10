package com.fiappostech.fastfood.adapter.gateway.payment;

import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.payment.PaymentResponse;
import com.fiappostech.fastfood.infrastructure.persistence.payment.PaymentFindByOrderIdRepository;

public class PaymentFindByOrderIdRepositoryGateway implements PaymentFindByOrderIdGateway {

   private final PaymentFindByOrderIdRepository paymentFindByOrderIdRepository;

   public PaymentFindByOrderIdRepositoryGateway(PaymentFindByOrderIdRepository paymentFindByOrderIdRepository) {
      this.paymentFindByOrderIdRepository = paymentFindByOrderIdRepository;
   }

   @Override
   public PaymentResponse execute(UUID orderId) {
      return paymentFindByOrderIdRepository.execute(orderId);
   }
}