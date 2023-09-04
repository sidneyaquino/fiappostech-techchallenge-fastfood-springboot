package com.fiappostech.fastfood.application.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.PaymentStatus;
import com.fiappostech.fastfood.application.ports.dto.request.PaymentRequest;
import com.fiappostech.fastfood.application.ports.dto.response.PaymentResponse;

public class PaymentDomain {

   private UUID paymentId;
   private UUID externalReference;
   private OrderDomain order;
   private LocalDateTime created;
   private Boolean approved;
   private PaymentStatus status;
   private String detail;
   private BigDecimal value;

   public PaymentDomain() {
   }

   public PaymentDomain(
         UUID paymentId,
         UUID externalReference,
         OrderDomain order,
         LocalDateTime created,
         Boolean approved,
         PaymentStatus status,
         String detail,
         BigDecimal value) {

      this.paymentId = paymentId;
      this.externalReference = externalReference;
      this.order = order;
      this.created = created;
      this.approved = approved;
      this.status = status;
      this.detail = detail;
      this.value = value;
   }

   public PaymentDomain(PaymentResponse paymentIResponse) {
      this.paymentId = paymentIResponse.paymentId();
      this.order = paymentIResponse.order() == null ? null
            : new OrderDomain(paymentIResponse.order());
      this.externalReference = paymentIResponse.externalReference();
      this.created = paymentIResponse.created();
      this.approved = paymentIResponse.approved();
      this.status = paymentIResponse.status();
      this.detail = paymentIResponse.detail();
      this.value = paymentIResponse.value();
   }

   public PaymentDomain(PaymentRequest paymentIRequest) {
      this.paymentId = paymentIRequest.paymentId();
      this.order = paymentIRequest.order() == null ? null
            : new OrderDomain(paymentIRequest.order());
      this.externalReference = paymentIRequest.externalReference();
      this.created = paymentIRequest.created();
      this.approved = paymentIRequest.approved();
      this.status = paymentIRequest.status();
      this.detail = paymentIRequest.detail();
      this.value = paymentIRequest.value();
   }

   public UUID getPaymentId() {
      return paymentId;
   }

   public void setPaymentId(UUID paymentId) {
      this.paymentId = paymentId;
   }

   public OrderDomain getOrder() {
      return order;
   }

   public void setOrder(OrderDomain order) {
      this.order = order;
   }

   public UUID getExternalReference() {
      return externalReference;
   }

   public void setExternalReference(UUID externalReference) {
      this.externalReference = externalReference;
   }

   public LocalDateTime getCreated() {
      return created;
   }

   public void setCreated(LocalDateTime created) {
      this.created = created;
   }

   public Boolean getApproved() {
      return approved;
   }

   public void setApproved(Boolean approved) {
      this.approved = approved;
   }

   public PaymentStatus getStatus() {
      return status;
   }

   public void setStatus(PaymentStatus status) {
      this.status = status;
   }

   public String getDetail() {
      return detail;
   }

   public void setDetail(String detail) {
      this.detail = detail;
   }

   public BigDecimal getValue() {
      return value;
   }

   public void setValue(BigDecimal value) {
      this.value = value;
   }

   public PaymentRequest toPaymentRequest() {
      return new PaymentRequest(
            this.getPaymentId(),
            this.getExternalReference(),
            this.getOrder() == null ? null : this.getOrder().toOrderRequest(),
            this.getCreated(),
            this.getApproved(),
            this.getStatus(),
            this.getDetail(),
            this.getValue());
   }

   public PaymentResponse toPaymentResponse() {
      return new PaymentResponse(
            this.getPaymentId(),
            this.getExternalReference(),
            this.getOrder() == null ? null : this.getOrder().toOrderResponse(),
            this.getCreated(),
            this.getApproved(),
            this.getStatus(),
            this.getDetail(),
            this.getValue());
   }
}