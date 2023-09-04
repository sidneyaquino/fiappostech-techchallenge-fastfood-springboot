package com.fiappostech.fastfood.application.core.usecases;

import java.time.LocalDateTime;

import com.fiappostech.fastfood.application.core.domain.OrderDomain;
import com.fiappostech.fastfood.application.ports.dto.PaymentStatus;
import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;
import com.fiappostech.fastfood.application.ports.dto.request.PaymentRequest;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.exception.ApplicationException;
import com.fiappostech.fastfood.application.ports.inbound.OrderCheckoutInputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderFindByIdOutputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderUpdateOutputPort;
import com.fiappostech.fastfood.application.ports.outbound.PaymentInsertOutputPort;

public class OrderCheckoutService implements OrderCheckoutInputPort {

   private final OrderUpdateOutputPort orderUpdateOutputPort;
   private final OrderFindByIdOutputPort orderFindByIdOutputPort;
   private final PaymentInsertOutputPort paymentInsertOutputPort;

   public OrderCheckoutService(
         OrderUpdateOutputPort orderUpdateOutputPort,
         OrderFindByIdOutputPort orderFindByIdOutputPort,
         PaymentInsertOutputPort paymentInsertOutputPort) {

      this.orderUpdateOutputPort = orderUpdateOutputPort;
      this.orderFindByIdOutputPort = orderFindByIdOutputPort;
      this.paymentInsertOutputPort = paymentInsertOutputPort;
   }

   @Override
   public OrderResponse execute(OrderRequest orderRequest) {
      var orderDomain = new OrderDomain(orderRequest);

      //
      // Business Rules before Request (validation).
      //
      var orderResponse = this.orderFindByIdOutputPort.execute(orderDomain.getOrderId());
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
      orderResponse = this.orderUpdateOutputPort.execute(orderDomain.toOrderRequest());
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
      var paymentResponse = this.paymentInsertOutputPort.execute(paymentRequest);

      return paymentResponse.order();
   }
}