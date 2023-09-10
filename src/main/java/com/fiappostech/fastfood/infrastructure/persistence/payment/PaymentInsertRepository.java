package com.fiappostech.fastfood.infrastructure.persistence.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.domain.dto.payment.PaymentRequest;
import com.fiappostech.fastfood.domain.dto.payment.PaymentResponse;
import com.fiappostech.fastfood.infrastructure.persistence.payment.entity.PaymentEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PaymentInsertRepository {

   @Autowired
   private final PaymentRepository paymentRepository;

   @Transactional
   public PaymentResponse execute(PaymentRequest paymentRequest) {
      var paymentEntity = new PaymentEntity(paymentRequest);
      paymentRepository.save(paymentEntity);
      return paymentEntity.toPaymentResponse();
   }
}