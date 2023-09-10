package com.fiappostech.fastfood.infrastructure.config.payment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapter.presenter.payment.PaymentFindByOrderIdPresenter;
import com.fiappostech.fastfood.adapter.presenter.payment.PaymentFindByOrderIdControllerPresenter;
import com.fiappostech.fastfood.adapter.presenter.payment.PaymentInsertPresenter;
import com.fiappostech.fastfood.adapter.presenter.payment.PaymentInsertControllerPresenter;
import com.fiappostech.fastfood.application.usecase.payment.PaymentFindByOrderIdUseCase;
import com.fiappostech.fastfood.application.usecase.payment.PaymentInsertUseCase;

@Configuration
public class PaymentPresenterConfig {

   @Bean
   public PaymentFindByOrderIdPresenter paymentFindByOrderIdPresenter(
         PaymentFindByOrderIdUseCase paymentFindByOrderIdUseCase) {

      return new PaymentFindByOrderIdControllerPresenter(paymentFindByOrderIdUseCase);
   }

   @Bean
   public PaymentInsertPresenter paymentInsertPresenter(
         PaymentInsertUseCase paymentInsertUseCase) {

      return new PaymentInsertControllerPresenter(paymentInsertUseCase);
   }
}