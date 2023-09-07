package com.fiappostech.fastfood.application.usecase.payment;

import java.time.LocalDateTime;

import com.fiappostech.fastfood.application.exception.BusinessException;
import com.fiappostech.fastfood.application.port.order.OrderFindByIdGateway;
import com.fiappostech.fastfood.application.port.order.OrderUpdateGateway;
import com.fiappostech.fastfood.application.port.payment.PaymentInsertGateway;
import com.fiappostech.fastfood.domain.entity.OrderDomain;
import com.fiappostech.fastfood.domain.entity.OrderTracking;
import com.fiappostech.fastfood.domain.entity.PaymentDomain;
import com.fiappostech.fastfood.domain.entity.PaymentStatus;
import com.fiappostech.fastfood.domain.port.order.dto.OrderRequest;
import com.fiappostech.fastfood.domain.port.payment.PaymentInsertUseCase;
import com.fiappostech.fastfood.domain.port.payment.dto.PaymentRequest;
import com.fiappostech.fastfood.domain.port.payment.dto.PaymentResponse;

public class PaymentInsertInteractor implements PaymentInsertUseCase {

   private final PaymentInsertGateway paymentInsertGateway;
   private final OrderFindByIdGateway orderFindByIdGateway;
   private final OrderUpdateGateway orderUpdateGateway;

   public PaymentInsertInteractor(
         PaymentInsertGateway paymentInsertGateway,
         OrderFindByIdGateway orderFindByIdGateway,
         OrderUpdateGateway orderUpdateGateway) {

      this.paymentInsertGateway = paymentInsertGateway;
      this.orderFindByIdGateway = orderFindByIdGateway;
      this.orderUpdateGateway = orderUpdateGateway;
   }

   @Override
   public PaymentResponse execute(PaymentRequest paymentRequest) {
      if (paymentRequest.order() == null || paymentRequest.order().orderId() == null) {
         throw new BusinessException("Order ID cannot be empty");
      }
      var orderId = paymentRequest.order().orderId();
      var orderResponse = this.orderFindByIdGateway.execute(orderId);
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
      var paymentResponse = this.paymentInsertGateway.execute(paymentDomain.toPaymentRequest());
      //
      // Business Rules after Response.
      //
      this.orderUpdateGateway.execute(paymentDomain.getOrder().toOrderRequest());

      return paymentResponse;
   }
}