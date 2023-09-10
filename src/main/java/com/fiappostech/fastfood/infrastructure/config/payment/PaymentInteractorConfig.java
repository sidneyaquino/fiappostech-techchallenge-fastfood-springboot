package com.fiappostech.fastfood.infrastructure.config.payment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapter.gateway.order.OrderFindByIdGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderUpdateGateway;
import com.fiappostech.fastfood.adapter.gateway.payment.PaymentFindByOrderIdGateway;
import com.fiappostech.fastfood.adapter.gateway.payment.PaymentInsertGateway;
import com.fiappostech.fastfood.application.usecase.payment.PaymentFindByOrderIdInteractor;
import com.fiappostech.fastfood.application.usecase.payment.PaymentFindByOrderIdUseCase;
import com.fiappostech.fastfood.application.usecase.payment.PaymentInsertInteractor;
import com.fiappostech.fastfood.application.usecase.payment.PaymentInsertUseCase;

@Configuration
public class PaymentInteractorConfig {

   @Bean
   public PaymentInsertUseCase paymentInsertUseCase(
         PaymentInsertGateway paymentInsertGateway,
         OrderFindByIdGateway orderFindByIdGateway,
         OrderUpdateGateway orderUpdateGateway) {

      return new PaymentInsertInteractor(paymentInsertGateway, orderFindByIdGateway, orderUpdateGateway);
   }

   @Bean
   public PaymentFindByOrderIdUseCase paymentFindByOrderIdUseCase(
         PaymentFindByOrderIdGateway paymentFindByOrderIdGateway) {

      return new PaymentFindByOrderIdInteractor(paymentFindByOrderIdGateway);
   }
}