package com.fiappostech.fastfood.infrastructure.persistence.order.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import com.fiappostech.fastfood.domain.dto.order.OrderProductResponse;
import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.domain.entity.OrderTracking;
import com.fiappostech.fastfood.infrastructure.persistence.customer.entity.CustomerEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(of = "orderId")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   @Column(name = "id")
   private UUID orderId;

   @ManyToOne(fetch = FetchType.LAZY, optional = true)
   @JoinColumn(name = "customer_id")
   private CustomerEntity customer;

   private LocalDateTime created;
   private LocalDateTime tracked;

   @Enumerated(EnumType.ORDINAL)
   private OrderTracking tracking;

   @Column(nullable = false)
   private BigDecimal value;

   // private List<OrderProductEntity> products;
   
   public OrderEntity(OrderRequest orderRequest) {
      this.orderId = orderRequest.orderId();
      this.customer = (orderRequest.customer() == null ? null : new CustomerEntity(orderRequest.customer()));
      this.created = orderRequest.created();
      this.tracked = orderRequest.tracked();
      this.tracking = orderRequest.tracking();
      this.value = orderRequest.value();
   }

   public OrderResponse toOrderResponse() {
      return toOrderResponse(new ArrayList<OrderProductResponse>());
   }

   public OrderResponse toOrderResponse(List<OrderProductResponse> listOrderProductResponse) {
      return new OrderResponse(
            this.getOrderId(),
            this.getCustomer() == null ? null : this.getCustomer().toCustomerResponse(),
            this.getCreated(),
            this.getTracked(),
            this.getTracking(),
            0L,
            this.getValue(),
            listOrderProductResponse);
   }

   public void update(OrderRequest orderRequest) {
      if (orderRequest.customer() != null) {
         this.customer = new CustomerEntity(orderRequest.customer());
      }
      if (orderRequest.created() != null) {
         this.created = orderRequest.created();
      }
      // if (orderRequest.tracking() != null) {
         this.tracking = orderRequest.tracking();
      // }
      // if (orderRequest.tracked() != null) {
         this.tracked = orderRequest.tracked();
      // }
      if (orderRequest.value() != null) {
         this.value = orderRequest.value();
      }
   }
}