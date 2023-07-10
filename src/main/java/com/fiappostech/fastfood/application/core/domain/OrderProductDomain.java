package com.fiappostech.fastfood.application.core.domain;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.request.OrderProductRequest;

public class OrderProductDomain {

   private UUID orderId;
   private UUID productId;
   private Short quantity;
   private BigDecimal value;

   public OrderProductDomain() {
   }

   public OrderProductDomain(UUID orderId, UUID productId, Short quantity, BigDecimal value) {
      this.orderId = orderId;
      this.productId = productId;
      this.quantity = quantity;
      this.value = value;
   }

   public OrderProductDomain(OrderProductRequest orderProductRequest) {
      this.orderId = orderProductRequest.orderId();
      this.productId = orderProductRequest.productId();
      this.quantity = orderProductRequest.quantity();
      this.value = orderProductRequest.value();
   }

   // public OrderProductDomain(OrderProductResponse orderProductResponse) {
   // this.orderId = orderProductResponse.orderId();
   // this.created = orderProductResponse.created();
   // this.tracked = orderProductResponse.tracked();
   // this.tracking = orderProductResponse.tracking();
   // this.value = orderResponse.value();
   // this.customer = orderProductResponse.customer() == null ? null : new
   // CustomerDomain(orderResponse.customer());
   // }

   public UUID getOrderId() {
      return orderId;
   }

   public void setOrderId(UUID orderId) {
      this.orderId = orderId;
   }

   public UUID getProductId() {
      return productId;
   }

   public void setProductId(UUID productId) {
      this.productId = productId;
   }

   public Short getQuantity() {
      return quantity;
   }

   public void setQuantity(Short quantity) {
      this.quantity = quantity;
   }

   public BigDecimal getValue() {
      return value;
   }

   public void setValue(BigDecimal value) {
      this.value = value;
   }

   public OrderProductRequest toOrderProductRequest() {
      return new OrderProductRequest(
            this.getOrderId(),
            this.getProductId(),
            this.getQuantity(),
            this.getValue());
   }

   // public OrderResponse toOrderResponse() {
   // return new OrderResponse(
   // this.getOrderId(),
   // this.getCustomer() == null ? null : this.getCustomer().toCustomerResponse(),
   // this.getCreated(),
   // this.getTracked(),
   // this.getTracking(),
   // this.getTrackingTime(),
   // this.getValue());
   // }
}