package com.fiappostech.fastfood.adapters.outbound.entity;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.Tracking;
import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;

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
@Table(name = "orders")
@Entity
public class OrderEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id")
   private UUID orderId;

   // @OnDelete(action = OnDeleteAction.CASCADE)
   @ManyToOne(fetch = FetchType.LAZY, optional = true)
   @JoinColumn(name = "customer_id") //, nullable = true)
   private CustomerEntity customer;

   @Column(nullable = false)
   private LocalDateTime created;

   private LocalDateTime tracked;

   @Enumerated(EnumType.ORDINAL)
   private Tracking tracking;

   @Column(nullable = false)
   private BigDecimal value;

   public OrderEntity(OrderRequest orderRequest) {
      this.orderId = orderRequest.orderId();
      this.customer = (orderRequest.customer() == null ? null : new CustomerEntity(orderRequest.customer()));
      this.created = orderRequest.created();
      this.tracked = orderRequest.tracked();
      this.tracking = orderRequest.tracking();
      this.value = orderRequest.value();
   }

   public OrderResponse toOrderResponse() {
      return new OrderResponse(
            this.getOrderId(),
            this.getCustomer() == null ? null : this.getCustomer().toCustomerResponse(),
            this.getCreated(),
            this.getTracked(),
            this.getTracking(),
            0,
            this.getValue());
   }

   public void update(OrderRequest orderRequest) {
      if (orderRequest.customer() != null) {
         this.customer = new CustomerEntity(orderRequest.customer());
      }
      if (orderRequest.tracking() != null) {
         this.tracking = orderRequest.tracking();
      }
      if (orderRequest.tracked() != null) {
         this.tracked = orderRequest.tracked();
      }
      if (orderRequest.value() != null) {
         this.value = orderRequest.value();
      }
   }
}