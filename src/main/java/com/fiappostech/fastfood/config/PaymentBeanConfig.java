package com.fiappostech.fastfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapters.outbound.OrderFindByIdRepository;
import com.fiappostech.fastfood.adapters.outbound.OrderUpdateRepository;
import com.fiappostech.fastfood.adapters.outbound.PaymentFindByOrderIdRepository;
import com.fiappostech.fastfood.adapters.outbound.PaymentInsertRepository;
import com.fiappostech.fastfood.application.core.usecases.PaymentFindByOrderIdService;
import com.fiappostech.fastfood.application.core.usecases.PaymentInsertService;

@Configuration
public class PaymentBeanConfig {

   @Bean
   public PaymentInsertService paymentInsertService(
         PaymentInsertRepository paymentInsertRepository,
         OrderFindByIdRepository orderFindByIdRepository,
         OrderUpdateRepository orderUpdateRepository) {

      return new PaymentInsertService(paymentInsertRepository, orderFindByIdRepository, orderUpdateRepository);
   }

   @Bean
   public PaymentFindByOrderIdService paymentFindByOrderIdService(
         PaymentFindByOrderIdRepository paymentFindByOrderIdRepository) {

      return new PaymentFindByOrderIdService(paymentFindByOrderIdRepository);
   }
}