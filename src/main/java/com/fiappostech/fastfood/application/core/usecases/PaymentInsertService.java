package com.fiappostech.fastfood.application.core.usecases;

import java.time.LocalDateTime;

import com.fiappostech.fastfood.application.core.domain.OrderDomain;
import com.fiappostech.fastfood.application.core.domain.PaymentDomain;
import com.fiappostech.fastfood.application.ports.dto.OrderTracking;
import com.fiappostech.fastfood.application.ports.dto.PaymentStatus;
import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;
import com.fiappostech.fastfood.application.ports.dto.request.PaymentRequest;
import com.fiappostech.fastfood.application.ports.dto.response.PaymentResponse;
import com.fiappostech.fastfood.application.ports.exception.ApplicationException;
import com.fiappostech.fastfood.application.ports.inbound.PaymentInsertInputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderFindByIdOutputPort;
import com.fiappostech.fastfood.application.ports.outbound.OrderUpdateOutputPort;
import com.fiappostech.fastfood.application.ports.outbound.PaymentInsertOutputPort;

public class PaymentInsertService implements PaymentInsertInputPort {

   private final PaymentInsertOutputPort paymentInsertOutputPort;
   private final OrderFindByIdOutputPort orderFindByIdOutputPort;
   private final OrderUpdateOutputPort orderUpdateOutputPort;

   public PaymentInsertService(
         PaymentInsertOutputPort paymentInsertOutputPort,
         OrderFindByIdOutputPort orderFindByIdOutputPort,
         OrderUpdateOutputPort orderUpdateOutputPort) {

      this.paymentInsertOutputPort = paymentInsertOutputPort;
      this.orderFindByIdOutputPort = orderFindByIdOutputPort;
      this.orderUpdateOutputPort = orderUpdateOutputPort;
   }

   @Override
   public PaymentResponse execute(PaymentRequest paymentRequest) {
      if (paymentRequest.order() == null || paymentRequest.order().orderId() == null) {
         throw new ApplicationException("Order ID cannot be empty");
      }
      var orderId = paymentRequest.order().orderId();
      var orderResponse = this.orderFindByIdOutputPort.execute(orderId);
      paymentRequest = new PaymentRequest(
            paymentRequest.paymentId(),
            paymentRequest.externalReference(),
            new OrderRequest(orderResponse),
            paymentRequest.created(),
            paymentRequest.approved(),
            paymentRequest.status(),
            paymentRequest.detail(),
            paymentRequest.value());
      var paymentDomain = new PaymentDomain(paymentRequest);
      paymentDomain.setOrder(new OrderDomain(orderResponse));

      //
      // Business Rules before Request (validation).
      //
      paymentDomain.setApproved(false);
      if (paymentDomain.getStatus().equals(PaymentStatus.APPROVED)) {
         if (paymentDomain.getValue().compareTo(paymentDomain.getOrder().getValue()) > -1) {
            paymentDomain.setApproved(true);

            paymentDomain.getOrder().setTracking(OrderTracking.RECEIVED);
            paymentDomain.getOrder().setTracked(LocalDateTime.now());
         } else {
            paymentDomain.setStatus(PaymentStatus.REJECTED);
            paymentDomain.setDetail("cc_rejected_insufficient_amount");
         }
      }
      if (!paymentDomain.getApproved()) {
         paymentDomain.getOrder().setTracking(null);
         paymentDomain.getOrder().setTracked(null);
      }
      paymentDomain.setCreated(LocalDateTime.now());
      //
      // Request.
      //
      var paymentResponse = this.paymentInsertOutputPort.execute(paymentDomain.toPaymentRequest());
      //
      // Business Rules after Response.
      //
      this.orderUpdateOutputPort.execute(paymentDomain.getOrder().toOrderRequest());

      return paymentResponse;
   }
}