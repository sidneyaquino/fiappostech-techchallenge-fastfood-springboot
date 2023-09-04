package com.fiappostech.fastfood.adapters.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.entity.PaymentEntity;
import com.fiappostech.fastfood.adapters.outbound.repository.PaymentRepository;
import com.fiappostech.fastfood.application.ports.dto.request.PaymentRequest;
import com.fiappostech.fastfood.application.ports.dto.response.PaymentResponse;
import com.fiappostech.fastfood.application.ports.outbound.PaymentInsertOutputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PaymentInsertRepository implements PaymentInsertOutputPort {

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