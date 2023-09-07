package com.fiappostech.fastfood.domain.entity;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fiappostech.fastfood.domain.port.order.dto.OrderRequest;
import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;

public class OrderDomain {

   private UUID orderId;
   private CustomerDomain customer;
   private LocalDateTime created;
   private LocalDateTime tracked;
   private OrderTracking tracking;
   private Long queueTime;
   private BigDecimal value;
   private List<OrderProductDomain> products;

   public OrderDomain() {
   }

   public OrderDomain(
         UUID orderId,
         CustomerDomain customer,
         LocalDateTime created,
         LocalDateTime tracked,
         OrderTracking tracking,
         Long queueTime,
         BigDecimal value,
         List<OrderProductDomain> products) {

      this.orderId = orderId;
      this.customer = customer;
      this.created = created;
      this.tracked = tracked;
      this.tracking = tracking;
      this.queueTime = queueTime;
      this.value = value;
      this.products = products;
   }

   public OrderDomain(OrderResponse orderResponse) {
      this.orderId = orderResponse.orderId();
      this.customer = orderResponse.customer() == null ? null
            : new CustomerDomain(orderResponse.customer());
      this.created = orderResponse.created();
      this.tracked = orderResponse.tracked();
      this.tracking = orderResponse.tracking();
      this.queueTime = orderResponse.tracked() == null ? null
            : orderResponse.tracking() == OrderTracking.FINISHED
               ? Duration.between(orderResponse.created(), orderResponse.tracked()).toMinutes()
               : Duration.between(orderResponse.created(), LocalDateTime.now()).toMinutes();
      this.value = orderResponse.value();
      this.products = orderResponse.products() == null ? null
            : orderResponse.products().stream().map(OrderProductDomain::new).toList();
   }

   public OrderDomain(OrderRequest orderRequest) {
      this.orderId = orderRequest.orderId();
      this.customer = orderRequest.customer() == null ? null
            : new CustomerDomain(orderRequest.customer());
      this.created = orderRequest.created();
      this.tracked = orderRequest.tracked();
      this.tracking = orderRequest.tracking();
      this.value = orderRequest.value();
      this.products = orderRequest.products() == null ? null
            : orderRequest.products().stream().map(OrderProductDomain::new).toList();
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

   public OrderTracking getTracking() {
      return tracking;
   }

   public void setTracking(OrderTracking tracking) {
      this.tracking = tracking;
   }

   public Long getQueueTime() {
      return queueTime;
   }

   // public void setQueueTime(Long queueTime) {
   //    this.queueTime = queueTime;
   // }

   public BigDecimal getValue() {
      return value;
   }

   public void setValue(BigDecimal value) {
      this.value = value;
   }

   public List<OrderProductDomain> getProducts() {
      return products;
   }

   public void setProducts(List<OrderProductDomain> products) {
      this.products = products;
   }

   public OrderRequest toOrderRequest() {
      return new OrderRequest(
            this.getOrderId(),
            this.getCustomer() == null ? null : this.getCustomer().toCustomerRequest(),
            this.getCreated(),
            this.getTracked(),
            this.getTracking(),
            this.getValue(),
            this.getProducts() == null ? null
                  : this.getProducts().stream().map(item -> item.toOrderProductRequest()).toList());
   }

   public OrderResponse toOrderResponse() {
      return new OrderResponse(
            this.getOrderId(),
            this.getCustomer() == null ? null : this.getCustomer().toCustomerResponse(),
            this.getCreated(),
            this.getTracked(),
            this.getTracking(),
            this.getQueueTime(),
            this.getValue(),
            this.getProducts() == null ? null
                  : this.getProducts().stream().map(item -> item.toOrderProductResponse()).toList());
   }
}