package com.fiappostech.fastfood.infrastructure.persistence.customer.entity;

import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.customer.CustomerRequest;
import com.fiappostech.fastfood.domain.dto.customer.CustomerResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(of = { "customerId", "personalId" })
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
public class CustomerEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   @Column(name = "id")
   private UUID customerId;

   @Column(length = 11, unique = true, nullable = false)
   private String personalId;

   @Column(nullable = false)
   private String email;

   @Column(length = 150, nullable = false)
   private String name;

   public CustomerEntity(CustomerRequest customerRequest) {
      this.customerId = customerRequest.customerId();
      this.personalId = customerRequest.personalId();
      this.email = customerRequest.email();
      this.name = customerRequest.name();
   }

   public CustomerResponse toCustomerResponse() {
      return new CustomerResponse(
            this.getCustomerId(),
            this.getPersonalId(),
            this.getEmail(),
            this.getName());
   }
}