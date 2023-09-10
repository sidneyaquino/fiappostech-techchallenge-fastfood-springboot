package com.fiappostech.fastfood.infrastructure.config.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiappostech.fastfood.adapter.presenter.order.OrderCheckoutPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderCheckoutControllerPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderFindAllUndeliveredPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderFindAllUndeliveredControllerPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderFindByIdPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderFindByIdControllerPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderFindByTrackingPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderFindByTrackingControllerPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderInsertPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderInsertControllerPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderUpdatePresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderUpdateControllerPresenter;
import com.fiappostech.fastfood.application.usecase.order.OrderCheckoutUseCase;
import com.fiappostech.fastfood.application.usecase.order.OrderFindAllUndeliveredUseCase;
import com.fiappostech.fastfood.application.usecase.order.OrderFindByIdUseCase;
import com.fiappostech.fastfood.application.usecase.order.OrderFindByTrackingUseCase;
import com.fiappostech.fastfood.application.usecase.order.OrderInsertUseCase;
import com.fiappostech.fastfood.application.usecase.order.OrderUpdateUseCase;

@Configuration
public class OrderPresenterConfig {

   @Bean
   public OrderInsertPresenter orderInsertPresenter(
         OrderInsertUseCase orderInsertUseCase) {

      return new OrderInsertControllerPresenter(orderInsertUseCase);
   }

   @Bean
   public OrderUpdatePresenter orderUpdatePresenter(
         OrderUpdateUseCase orderUpdateUseCase) {

      return new OrderUpdateControllerPresenter(orderUpdateUseCase);
   }

   @Bean
   public OrderFindByTrackingPresenter orderFindByTrackingPresenter(
         OrderFindByTrackingUseCase orderFindByTrackingUseCase) {

      return new OrderFindByTrackingControllerPresenter(orderFindByTrackingUseCase);
   }

   @Bean
   public OrderFindByIdPresenter orderFindByIdPresenter(
         OrderFindByIdUseCase orderFindByIdUseCase) {

      return new OrderFindByIdControllerPresenter(orderFindByIdUseCase);
   }

   @Bean
   public OrderCheckoutPresenter orderCheckoutPresenter(
         OrderCheckoutUseCase orderCheckoutUseCase) {

      return new OrderCheckoutControllerPresenter(orderCheckoutUseCase);
   }

   @Bean
   public OrderFindAllUndeliveredPresenter orderFindAllUndeliveredPresenter(
         OrderFindAllUndeliveredUseCase orderFindAllUndeliveredUseCase) {

      return new OrderFindAllUndeliveredControllerPresenter(orderFindAllUndeliveredUseCase);
   }
}