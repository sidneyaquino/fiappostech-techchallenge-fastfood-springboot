package com.fiappostech.fastfood.adapters.outbound.entity;

import java.math.BigDecimal;

import com.fiappostech.fastfood.application.ports.dto.request.OrderProductRequest;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(of = "orderProductId")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order_products")
public class OrderProductEntity {
   
   @EmbeddedId
   // @Column(name = "id")
   private OrderProductPk orderProductId = new OrderProductPk();

   @Column(nullable = false)
   private Short quantity; 

   @Column(nullable = false)
   private BigDecimal value;

   public OrderProductEntity(OrderProductRequest orderProductRequest, OrderEntity orderEntity, ProductEntity productEntity){
      this.orderProductId.setOrder(orderEntity);
      this.orderProductId.setProduct(productEntity);
      this.quantity = orderProductRequest.quantity();
      this.value = productEntity.getValue();
   }

   // public OrderEntity(OrderRequest orderRequest) {
   //    this.orderId = orderRequest.orderId();
   //    this.customer = (orderRequest.customer() == null ? null : new CustomerEntity(orderRequest.customer()));
   //    this.created = orderRequest.created();
   //    this.tracked = orderRequest.tracked();
   //    this.tracking = orderRequest.tracking();
   //    this.value = orderRequest.value();
   // }

   // public OrderResponse toOrderResponse() {
   //    return new OrderResponse(
   //          this.getOrderId(),
   //          this.getCustomer() == null ? null : this.getCustomer().toCustomerResponse(),
   //          this.getCreated(),
   //          this.getTracked(),
   //          this.getTracking(),
   //          0,
   //          this.getValue());
   // }
}