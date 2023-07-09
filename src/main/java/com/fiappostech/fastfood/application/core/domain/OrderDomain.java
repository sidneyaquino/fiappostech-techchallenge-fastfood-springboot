package com.fiappostech.fastfood.application.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.Tracking;
import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;

public class OrderDomain {

   private UUID orderId;
   private CustomerDomain customer;
   private LocalDateTime created;
   private LocalDateTime tracked;
   private Tracking tracking;
   private Integer trackingTime;
   private BigDecimal value;

   public OrderDomain() {
   }

   public OrderDomain(
         UUID orderId,
         CustomerDomain customer,
         LocalDateTime created,
         LocalDateTime tracked,
         Tracking tracking,
         Integer trackingTime,
         BigDecimal value) {

      this.orderId = orderId;
      this.customer = customer;
      this.created = created;
      this.tracked = tracked;
      this.tracking = tracking;
      this.trackingTime = trackingTime;
      this.value = value;
   }

   public OrderDomain(OrderResponse orderResponse) {
      this.orderId = orderResponse.orderId();
      this.customer = orderResponse.customer() == null ? null : new CustomerDomain(orderResponse.customer());
      this.created = orderResponse.created();
      this.tracked = orderResponse.tracked();
      this.tracking = orderResponse.tracking();
      this.trackingTime = orderResponse.trackingTime();
      this.value = orderResponse.value();
   }

   public OrderDomain(OrderRequest orderRequest) {
      this.orderId = orderRequest.orderId();
      this.customer = orderRequest.customer() == null ? null : new CustomerDomain(orderRequest.customer());
      this.created = orderRequest.created();
      this.tracked = orderRequest.tracked();
      this.tracking = orderRequest.tracking();
      this.value = orderRequest.value();
   }

   public UUID getOrderId() {
      return orderId;
   }

   public void setOrderId(UUID orderId) {
      this.orderId = orderId;
   }

   public CustomerDomain getCustomer() {
      return customer;
   }

   public void setCustomer(CustomerDomain customer) {
      this.customer = customer;
   }

   public LocalDateTime getCreated() {
      return created;
   }

   public void setCreated(LocalDateTime created) {
      this.created = created;
   }

   public LocalDateTime getTracked() {
      return tracked;
   }

   public void setTracked(LocalDateTime tracked) {
      this.tracked = tracked;
   }

   public Tracking getTracking() {
      return tracking;
   }

   public void setTracking(Tracking tracking) {
      this.tracking = tracking;
   }

   public Integer getTrackingTime() {
      return trackingTime;
   }

   public void setTrackingTime(Integer trackingTime) {
      this.trackingTime = trackingTime;
   }

   public BigDecimal getValue() {
      return value;
   }

   public void setValue(BigDecimal value) {
      this.value = value;
   }

   public OrderRequest toOrderRequest() {
      return new OrderRequest(
            this.getOrderId(),
            this.getCustomer() == null ? null :this.getCustomer().toCustomerRequest(),
            this.getCreated(),
            this.getTracked(),
            this.getTracking(),
            this.getValue());
   }

   public OrderResponse toOrderResponse() {
      return new OrderResponse(
            this.getOrderId(),
            this.getCustomer() == null ? null : this.getCustomer().toCustomerResponse(),
            this.getCreated(),
            this.getTracked(),
            this.getTracking(),
            this.getTrackingTime(),
            this.getValue());
   }
}