package com.fiappostech.fastfood.infrastructure.persistence.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.application.port.payment.PaymentInsertGateway;
import com.fiappostech.fastfood.domain.port.payment.dto.PaymentRequest;
import com.fiappostech.fastfood.domain.port.payment.dto.PaymentResponse;
import com.fiappostech.fastfood.infrastructure.persistence.payment.entity.PaymentEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PaymentInsertRepository implements PaymentInsertGateway {

   @Autowired
   private final PaymentRepository paymentRepository;

   @Transactional
   @Override
   public PaymentResponse execute(PaymentRequest paymentRequest) {
      var paymentEntity = new PaymentEntity(paymentRequest);
      paymentRepository.save(paymentEntity);
      return paymentEntity.toPaymentResponse();
   }
}