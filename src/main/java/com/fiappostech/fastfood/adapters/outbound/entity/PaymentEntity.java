package com.fiappostech.fastfood.adapters.outbound.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.AnyKeyJavaClass;

import com.fiappostech.fastfood.application.ports.dto.PaymentStatus;
import com.fiappostech.fastfood.application.ports.dto.request.PaymentRequest;
import com.fiappostech.fastfood.application.ports.dto.response.PaymentResponse;

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

@EqualsAndHashCode(of = "paymentId")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payments")
public class PaymentEntity {

   @Id
   @AnyKeyJavaClass(UUID.class)
   @GeneratedValue(strategy = GenerationType.UUID)
   @Column(name = "id")
   private UUID paymentId;

   @ManyToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumn(name = "order_id")
   private OrderEntity order;

   @AnyKeyJavaClass(UUID.class)
   @Column(name = "external_reference", unique = true) //, nullable = false)
   private UUID externalReference;

   @Column(nullable = false)
   private LocalDateTime created;

   @Column(nullable = false)
   private Boolean approved = false;

   @Enumerated(EnumType.ORDINAL)
   @Column(nullable = false)
   private PaymentStatus status;

   @Column(name = "status_detail", length = 50)
   private String detail;

   @Column(nullable = false)
   private BigDecimal value;

   public PaymentEntity(PaymentRequest paymentRequest) {
      this.paymentId = paymentRequest.paymentId();
      this.externalReference = paymentRequest.externalReference();
      this.order = (paymentRequest.order() == null ? null : new OrderEntity(paymentRequest.order()));
      this.created = paymentRequest.created();
      this.approved = paymentRequest.approved();
      this.status = paymentRequest.status();
      this.detail = paymentRequest.detail();
      this.value = paymentRequest.value();
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