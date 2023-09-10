package com.fiappostech.fastfood.infrastructure.config.payment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapter.gateway.payment.PaymentFindByOrderIdGateway;
import com.fiappostech.fastfood.adapter.gateway.payment.PaymentFindByOrderIdRepositoryGateway;
import com.fiappostech.fastfood.adapter.gateway.payment.PaymentInsertGateway;
import com.fiappostech.fastfood.adapter.gateway.payment.PaymentInsertRepositoryGateway;
import com.fiappostech.fastfood.infrastructure.persistence.payment.PaymentFindByOrderIdRepository;
import com.fiappostech.fastfood.infrastructure.persistence.payment.PaymentInsertRepository;

@Configuration
public class PaymentGatewayConfig {

   @Bean
   public PaymentFindByOrderIdGateway paymentFindByOrderIdGateway(
         PaymentFindByOrderIdRepository paymentFindByOrderIdRepository) {

      return new PaymentFindByOrderIdRepositoryGateway(paymentFindByOrderIdRepository);
   }

   @Bean
   public PaymentInsertGateway paymentInsertGateway(
         PaymentInsertRepository paymentInsertRepository) {

      return new PaymentInsertRepositoryGateway(paymentInsertRepository);
   }
}