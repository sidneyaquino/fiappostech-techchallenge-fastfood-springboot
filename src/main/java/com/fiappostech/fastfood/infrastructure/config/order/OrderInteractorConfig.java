package com.fiappostech.fastfood.infrastructure.config.order;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapter.gateway.customer.CustomerIdentifyGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderFindAllUndeliveredGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderFindByIdGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderFindByTrackingGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderInsertGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderUpdateGateway;
import com.fiappostech.fastfood.adapter.gateway.payment.PaymentInsertGateway;
import com.fiappostech.fastfood.adapter.gateway.product.ProductFindByIdGateway;
import com.fiappostech.fastfood.application.usecase.order.OrderCheckoutInteractor;
import com.fiappostech.fastfood.application.usecase.order.OrderCheckoutUseCase;
import com.fiappostech.fastfood.application.usecase.order.OrderFindAllUndeliveredInteractor;
import com.fiappostech.fastfood.application.usecase.order.OrderFindAllUndeliveredUseCase;
import com.fiappostech.fastfood.application.usecase.order.OrderFindByIdInteractor;
import com.fiappostech.fastfood.application.usecase.order.OrderFindByIdUseCase;
import com.fiappostech.fastfood.application.usecase.order.OrderFindByTrackingInteractor;
import com.fiappostech.fastfood.application.usecase.order.OrderFindByTrackingUseCase;
import com.fiappostech.fastfood.application.usecase.order.OrderInsertInteractor;
import com.fiappostech.fastfood.application.usecase.order.OrderInsertUseCase;
import com.fiappostech.fastfood.application.usecase.order.OrderUpdateInteractor;
import com.fiappostech.fastfood.application.usecase.order.OrderUpdateUseCase;
import com.fiappostech.fastfood.application.usecase.order.validator.OrderCheckoutExistsValidator;
import com.fiappostech.fastfood.application.usecase.order.validator.OrderCheckoutNotExistsValidator;
import com.fiappostech.fastfood.application.usecase.order.validator.OrderCheckoutValidator;
import com.fiappostech.fastfood.application.usecase.order.validator.OrderPaymentNotExistsValidator;
import com.fiappostech.fastfood.application.usecase.order.validator.OrderProductDontMatchValidation;
import com.fiappostech.fastfood.application.usecase.order.validator.OrderTrackingUpdatedValidator;
import com.fiappostech.fastfood.application.usecase.order.validator.OrderUpdateValidator;

@Configuration
public class OrderInteractorConfig {

   @Bean
   public OrderInsertUseCase orderInsertUseCase(
         OrderInsertGateway orderInsertGateway,
         ProductFindByIdGateway productFindByIGateway,
         CustomerIdentifyGateway customerIdentifyGateway) {

      return new OrderInsertInteractor(
            orderInsertGateway, productFindByIGateway, customerIdentifyGateway);
   }

   @Bean
   public OrderCheckoutValidator orderCheckoutExistsValidator() {
      return new OrderCheckoutExistsValidator();
   }

   @Bean
   public OrderCheckoutValidator orderCheckoutItemsMatchValidation() {
      return new OrderProductDontMatchValidation();
   }

   @Bean
   public OrderCheckoutUseCase orderCheckoutUseCase(
         OrderUpdateGateway orderUpdateGateway,
         OrderFindByIdGateway orderFindByIdGateway,
         PaymentInsertGateway paymentInsertGateway,
         List<OrderCheckoutValidator> listOrderCheckoutValidation) {

      return new OrderCheckoutInteractor(
            orderUpdateGateway, orderFindByIdGateway, paymentInsertGateway, listOrderCheckoutValidation);
   }

   @Bean
   public OrderUpdateValidator orderCheckoutNotExistsValidator() {
      return new OrderCheckoutNotExistsValidator();
   }

   @Bean
   public OrderUpdateValidator orderPaymentNotExistsValidator() {
      return new OrderPaymentNotExistsValidator();
   }

   @Bean
   public OrderUpdateValidator orderTrackingUpdatedValidator() {
      return new OrderTrackingUpdatedValidator();
   }   

   @Bean
   public OrderUpdateUseCase orderUpdateUseCase(
         OrderUpdateGateway orderUpdateGateway,
         OrderFindByIdGateway orderFindByIdGateway,
         List<OrderUpdateValidator> listOrderUpdateValidation) {

      return new OrderUpdateInteractor(
            orderUpdateGateway, orderFindByIdGateway, listOrderUpdateValidation);
   }

   @Bean
   public OrderFindByIdUseCase orderFindByUseCase(
         OrderFindByIdGateway orderFindByIdGateway) {

      return new OrderFindByIdInteractor(orderFindByIdGateway);
   }

   @Bean
   public OrderFindByTrackingUseCase orderFindByTrackingUseCase(
         OrderFindByTrackingGateway orderFindByTrackingGateway) {

      return new OrderFindByTrackingInteractor(orderFindByTrackingGateway);
   }

   @Bean
   public OrderFindAllUndeliveredUseCase orderFindAllUndeliveredUseCase(
         OrderFindAllUndeliveredGateway orderFindAllUndeliveredGateway) {

      return new OrderFindAllUndeliveredInteractor(orderFindAllUndeliveredGateway);
   }
}