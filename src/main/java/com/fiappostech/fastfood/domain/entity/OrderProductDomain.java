package com.fiappostech.fastfood.domain.entity;

import java.math.BigDecimal;
import java.util.UUID;

import com.fiappostech.fastfood.domain.port.order.dto.OrderProductRequest;
import com.fiappostech.fastfood.domain.port.order.dto.OrderProductResponse;

public class OrderProductDomain {

   private UUID productId;
   private String description;
   private Short quantity;
   private BigDecimal value;

   public OrderProductDomain() {
   }

   public OrderProductDomain(UUID productId, String description, Short quantity, BigDecimal value) {
      this.productId = productId;
      this.description = description;
      this.quantity = quantity;
      this.value = value;
   }

   public OrderProductDomain(OrderProductRequest orderProductRequest) {
      this.productId = orderProductRequest.productId();
      this.description = null;
      this.quantity = orderProductRequest.quantity();
      this.value = orderProductRequest.value();
   }

   public OrderProductDomain(OrderProductResponse orderProductResponse) {
      this.productId = orderProductResponse.productId();
      this.description = orderProductResponse.description();
      this.quantity = orderProductResponse.quantity();
      this.value = orderProductResponse.value();
   }

   public UUID getProductId() {
      return productId;
   }

   public void setProductId(UUID productId) {
      this.productId = productId;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
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
            this.getProductId(),
            this.getQuantity(),
            this.getValue());
   }

   public OrderProductResponse toOrderProductResponse() {
      return new OrderProductResponse(
            this.getProductId(),
            this.getDescription(),
            this.getQuantity(),
            this.getValue());
   }
}