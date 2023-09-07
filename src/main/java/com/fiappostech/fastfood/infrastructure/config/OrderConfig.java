package com.fiappostech.fastfood.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapter.presenter.order.OrderCheckoutPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderFindAllUndeliveredPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderFindByIdPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderFindByTrackingPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderInsertPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderUpdatePresenter;
import com.fiappostech.fastfood.application.usecase.order.OrderCheckoutInteractor;
import com.fiappostech.fastfood.application.usecase.order.OrderFindAllUndeliveredInteractor;
import com.fiappostech.fastfood.application.usecase.order.OrderFindByIdInteractor;
import com.fiappostech.fastfood.application.usecase.order.OrderFindByTrackingInteractor;
import com.fiappostech.fastfood.application.usecase.order.OrderInsertInteractor;
import com.fiappostech.fastfood.application.usecase.order.OrderUpdateInteractor;
import com.fiappostech.fastfood.domain.port.order.OrderCheckoutUseCase;
import com.fiappostech.fastfood.domain.port.order.OrderFindAllUndeliveredUseCase;
import com.fiappostech.fastfood.domain.port.order.OrderFindByIdUseCase;
import com.fiappostech.fastfood.domain.port.order.OrderFindByTrackingUseCase;
import com.fiappostech.fastfood.domain.port.order.OrderInsertUseCase;
import com.fiappostech.fastfood.domain.port.order.OrderUpdateUseCase;
import com.fiappostech.fastfood.infrastructure.persistence.customer.CustomerFindByPersonalIdRepository;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderFindAllUndeliveredRepository;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderFindByIdRepository;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderFindByTrackingRepository;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderInsertRepository;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderUpdateRepository;
import com.fiappostech.fastfood.infrastructure.persistence.payment.PaymentInsertRepository;
import com.fiappostech.fastfood.infrastructure.persistence.product.ProductFindByIdRepository;

@Configuration
public class OrderConfig {

   @Bean
   public OrderInsertPresenter orderInsertPresenter(
         OrderInsertUseCase orderInsertUseCase) {

      return new OrderInsertPresenter(orderInsertUseCase);
   }

   @Bean
   public OrderUpdatePresenter orderUpdatePresenter(
         OrderUpdateUseCase orderUpdateUseCase) {

      return new OrderUpdatePresenter(orderUpdateUseCase);
   }

   @Bean
   public OrderFindByTrackingPresenter orderFindByTrackingPresenter(
         OrderFindByTrackingUseCase orderFindByTrackingUseCase) {

      return new OrderFindByTrackingPresenter(orderFindByTrackingUseCase);
   }

   @Bean
   public OrderFindByIdPresenter orderFindByIdPresenter(
         OrderFindByIdUseCase orderFindByIdUseCase) {

      return new OrderFindByIdPresenter(orderFindByIdUseCase);
   }

   @Bean
   public OrderCheckoutPresenter orderCheckoutPresenter(
         OrderCheckoutUseCase orderCheckoutUseCase) {

      return new OrderCheckoutPresenter(orderCheckoutUseCase);
   }

   @Bean
   public OrderFindAllUndeliveredPresenter orderFindAllUndeliveredPresenter(
         OrderFindAllUndeliveredUseCase orderFindAllUndeliveredUseCase) {

      return new OrderFindAllUndeliveredPresenter(orderFindAllUndeliveredUseCase);
   }

   @Bean
   public OrderInsertInteractor orderInsertInteractor(
         OrderInsertRepository orderInsertRepository,
         ProductFindByIdRepository productFindByIRepository,
         CustomerFindByPersonalIdRepository customerFindByPersonalIdRepository) {

      return new OrderInsertInteractor(
            orderInsertRepository, productFindByIRepository, customerFindByPersonalIdRepository);
   }

   @Bean
   public OrderCheckoutInteractor orderCheckoutInteractor(
         OrderUpdateRepository orderUpdateRepository,
         OrderFindByIdRepository orderFindByIdRepository,
         PaymentInsertRepository paymentInsertRepository) {

      return new OrderCheckoutInteractor(
            orderUpdateRepository, orderFindByIdRepository, paymentInsertRepository);
   }

   @Bean
   public OrderUpdateInteractor orderUpdateInteractor(
         OrderUpdateRepository orderUpdateRepository,
         OrderFindByIdRepository orderFindByIdRepository) {

      return new OrderUpdateInteractor(orderUpdateRepository, orderFindByIdRepository);
   }

   @Bean
   public OrderFindByIdInteractor orderFindByIdInteractor(
         OrderFindByIdRepository orderFindByIdRepository) {

      return new OrderFindByIdInteractor(orderFindByIdRepository);
   }

   @Bean
   public OrderFindByTrackingInteractor orderFindByTrackingInteractor(
         OrderFindByTrackingRepository orderFindByTrackingRepository) {

      return new OrderFindByTrackingInteractor(orderFindByTrackingRepository);
   }

   @Bean
   public OrderFindAllUndeliveredInteractor orderFindAllUndeliveredInteractor(
         OrderFindAllUndeliveredRepository orderFindAllUndeliveredRepository) {

      return new OrderFindAllUndeliveredInteractor(orderFindAllUndeliveredRepository);
   }
}