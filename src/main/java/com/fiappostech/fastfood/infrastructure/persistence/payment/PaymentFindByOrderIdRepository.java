package com.fiappostech.fastfood.infrastructure.persistence.payment;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.domain.dto.payment.PaymentResponse;
import com.fiappostech.fastfood.infrastructure.exception.RecordNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PaymentFindByOrderIdRepository {

   @Autowired
   private final PaymentRepository paymentRepository;

   @Transactional(readOnly = true)
   public PaymentResponse execute(UUID orderId) {
      var paymentProjection = paymentRepository.findByOrderId(orderId);
      if(paymentProjection == null) {
         throw new RecordNotFoundException(orderId);
      }
      
      var paymentEntity = paymentRepository.getReferenceById(paymentProjection.getPaymentId());
      if(paymentEntity == null) {
         throw new RecordNotFoundException(orderId);
      }
      return paymentEntity.toPaymentResponse();
   }
}