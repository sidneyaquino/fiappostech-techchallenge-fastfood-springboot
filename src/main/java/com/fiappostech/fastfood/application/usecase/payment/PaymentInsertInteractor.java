package com.fiappostech.fastfood.application.usecase.payment;

import java.time.LocalDateTime;

import com.fiappostech.fastfood.adapter.gateway.order.OrderFindByIdGateway;
import com.fiappostech.fastfood.adapter.gateway.order.OrderUpdateGateway;
import com.fiappostech.fastfood.adapter.gateway.payment.PaymentInsertGateway;
import com.fiappostech.fastfood.application.exception.ApplicationException;
import com.fiappostech.fastfood.domain.dto.payment.PaymentRequest;
import com.fiappostech.fastfood.domain.dto.payment.PaymentResponse;
import com.fiappostech.fastfood.domain.entity.OrderDomain;
import com.fiappostech.fastfood.domain.entity.OrderTracking;
import com.fiappostech.fastfood.domain.entity.PaymentDomain;
import com.fiappostech.fastfood.domain.entity.PaymentStatus;

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
      
      //
      // Business Rules before Request (validation).
      //
      if (paymentRequest.order() == null || paymentRequest.order().orderId() == null) {
         throw new ApplicationException("Order ID cannot be empty");
      }
      var orderResponse = this.orderFindByIdGateway.execute(paymentRequest.order().orderId());

      var paymentDomain = new PaymentDomain(paymentRequest);
      paymentDomain.setOrder(new OrderDomain(orderResponse));
      setApproved(paymentDomain);
      
      //
      // Request.
      //
      var paymentResponse = this.paymentInsertGateway.execute(paymentDomain.toPaymentRequest());
      paymentDomain = new PaymentDomain(paymentResponse);
      this.orderUpdateGateway.execute(paymentDomain.getOrder().toOrderRequest());
      
      //
      // Business Rules after Response.
      //

      return paymentDomain.toPaymentResponse();
   }

   private void setApproved(PaymentDomain paymentDomain){
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
   }
}