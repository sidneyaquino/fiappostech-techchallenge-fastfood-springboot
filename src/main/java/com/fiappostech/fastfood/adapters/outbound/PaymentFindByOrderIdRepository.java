package com.fiappostech.fastfood.adapters.outbound;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.repository.PaymentRepository;
import com.fiappostech.fastfood.application.ports.dto.response.PaymentResponse;
import com.fiappostech.fastfood.application.ports.outbound.PaymentFindByOrderIdOutputPort;
import com.fiappostech.fastfood.config.exception.RecordNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PaymentFindByOrderIdRepository implements PaymentFindByOrderIdOutputPort {

   @Autowired
   private final PaymentRepository paymentRepository;

   @Transactional(readOnly = true)
   @Override
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