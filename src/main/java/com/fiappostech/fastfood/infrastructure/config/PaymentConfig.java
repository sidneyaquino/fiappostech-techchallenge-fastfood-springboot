package com.fiappostech.fastfood.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapter.presenter.payment.PaymentFindByOrderIdPresenter;
import com.fiappostech.fastfood.adapter.presenter.payment.PaymentInsertPresenter;
import com.fiappostech.fastfood.application.usecase.payment.PaymentFindByOrderIdInteractor;
import com.fiappostech.fastfood.application.usecase.payment.PaymentInsertInteractor;
import com.fiappostech.fastfood.domain.port.payment.PaymentFindByOrderIdUseCase;
import com.fiappostech.fastfood.domain.port.payment.PaymentInsertUseCase;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderFindByIdRepository;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderUpdateRepository;
import com.fiappostech.fastfood.infrastructure.persistence.payment.PaymentFindByOrderIdRepository;
import com.fiappostech.fastfood.infrastructure.persistence.payment.PaymentInsertRepository;

@Configuration
public class PaymentConfig {

   @Bean
   public PaymentFindByOrderIdPresenter paymentFindByOrderIdPresenter(
         PaymentFindByOrderIdUseCase paymentFindByOrderIdUseCase) {

      return new PaymentFindByOrderIdPresenter(paymentFindByOrderIdUseCase);
   }

   @Bean
   public PaymentInsertPresenter paymentInsertPresenter(
         PaymentInsertUseCase paymentInsertUseCase) {

      return new PaymentInsertPresenter(paymentInsertUseCase);
   }

   @Bean
   public PaymentInsertInteractor paymentInsertInteractor(
         PaymentInsertRepository paymentInsertRepository,
         OrderFindByIdRepository orderFindByIdRepository,
         OrderUpdateRepository orderUpdateRepository) {

      return new PaymentInsertInteractor(paymentInsertRepository, orderFindByIdRepository, orderUpdateRepository);
   }

   @Bean
   public PaymentFindByOrderIdInteractor paymentFindByOrderIdInteractor(
         PaymentFindByOrderIdRepository paymentFindByOrderIdRepository) {

      return new PaymentFindByOrderIdInteractor(paymentFindByOrderIdRepository);
   }
}