package com.fiappostech.fastfood.application.usecase.order;

import java.time.LocalDateTime;
import java.util.List;

import com.fiappostech.fastfood.adapter.gateway.order.OrderFindByIdGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderUpdateGateway;
import com.fiappostech.fastfood.adapter.gateway.payment.PaymentInsertGateway;
import com.fiappostech.fastfood.application.usecase.order.validator.OrderCheckoutValidator;
import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.domain.dto.payment.PaymentRequest;
import com.fiappostech.fastfood.domain.entity.OrderDomain;

public class OrderCheckoutInteractor implements OrderCheckoutUseCase {

   private final OrderUpdateGateway orderUpdateGateway;
   private final OrderFindByIdGateway orderFindByIdGateway;
   private final PaymentInsertGateway paymentInsertGateway;
   private final List<OrderCheckoutValidator> listOrderCheckoutValidator;

   public OrderCheckoutInteractor(
         OrderUpdateGateway orderUpdateGateway,
         OrderFindByIdGateway orderFindByIdGateway,
         PaymentInsertGateway paymentInsertGateway,
         List<OrderCheckoutValidator> listOrderCheckoutValidator) {

      this.orderUpdateGateway = orderUpdateGateway;
      this.orderFindByIdGateway = orderFindByIdGateway;
      this.paymentInsertGateway = paymentInsertGateway;
      this.listOrderCheckoutValidator = listOrderCheckoutValidator;
   }

   @Override
   public OrderResponse execute(OrderRequest orderRequest) {

      //
      // Business Rules before Request (validation).
      //
      this.listOrderCheckoutValidator.forEach(item -> item.validate(orderRequest,
            this.orderFindByIdGateway.execute(orderRequest.orderId())));

      var orderDomain = new OrderDomain(orderRequest);
      orderDomain.setCreated(LocalDateTime.now());

      //
      // Request.
      //
      orderDomain = new OrderDomain(this.orderUpdateGateway.execute(orderDomain.toOrderRequest()));
      var paymentRequest = new PaymentRequest(orderDomain.toOrderRequest());
      var paymentResponse = this.paymentInsertGateway.execute(paymentRequest);

      //
      // Business Rules before Response.
      //

      return paymentResponse.order();  // PENDENCY: validate return.
   }
}