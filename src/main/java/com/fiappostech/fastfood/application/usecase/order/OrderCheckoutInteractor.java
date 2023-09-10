package com.fiappostech.fastfood.application.usecase.order;

import java.time.LocalDateTime;

import com.fiappostech.fastfood.adapter.gateway.order.OrderFindByIdGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderUpdateGateway;
import com.fiappostech.fastfood.adapter.gateway.payment.PaymentInsertGateway;
import com.fiappostech.fastfood.application.exception.ApplicationException;
import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.domain.dto.payment.PaymentRequest;
import com.fiappostech.fastfood.domain.entity.OrderDomain;
import com.fiappostech.fastfood.domain.entity.PaymentStatus;

public class OrderCheckoutInteractor implements OrderCheckoutUseCase {

   private final OrderUpdateGateway orderUpdateGateway;
   private final OrderFindByIdGateway orderFindByIdGateway;
   private final PaymentInsertGateway paymentInsertGateway;

   public OrderCheckoutInteractor(
         OrderUpdateGateway orderUpdateGateway,
         OrderFindByIdGateway orderFindByIdGateway,
         PaymentInsertGateway paymentInsertGateway) {

      this.orderUpdateGateway = orderUpdateGateway;
      this.orderFindByIdGateway = orderFindByIdGateway;
      this.paymentInsertGateway = paymentInsertGateway;
   }

   @Override
   public OrderResponse execute(OrderRequest orderRequest) {
      var orderDomain = new OrderDomain(orderRequest);

      //
      // Business Rules before Request (validation).
      //
      var orderResponse = this.orderFindByIdGateway.execute(orderDomain.getOrderId());
      if (orderResponse.created() != null) {
         throw new ApplicationException("Order checkout already done");
      }
      if (orderResponse.products().size() != orderDomain.getProducts().size()) {
         throw new ApplicationException("Order Items are different");
      }
      for (var product : orderResponse.products()) {
         orderDomain.getProducts().stream()         
            .filter(item -> item.getProductId().equals(product.productId()))
            .filter(item -> item.getQuantity().equals(product.quantity()))
            .findFirst().orElseThrow(() -> new ApplicationException("Order Items are different"));
      }
      orderDomain.setCreated(LocalDateTime.now());
      //
      // Request.
      //
      orderResponse = this.orderUpdateGateway.execute(orderDomain.toOrderRequest());
      orderDomain = new OrderDomain(orderResponse);
      //
      // Business Rules before Response.
      //
      var paymentRequest = new PaymentRequest(
         null,
         null,
         orderDomain.toOrderRequest(),
         LocalDateTime.now(),
         false,
         PaymentStatus.PENDING,
         "Waiting Payment Reply...",
         orderDomain.getValue()
      );
      var paymentResponse = this.paymentInsertGateway.execute(paymentRequest);

      return paymentResponse.order();
   }
}