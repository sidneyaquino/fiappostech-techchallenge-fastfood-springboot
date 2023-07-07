package com.fiappostech.fastfood.adapters.outbound.entity;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.request.CustomerRequest;
import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;

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

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "personalId")
@Getter
@Setter
@Entity
@Table(name = "customers")
public class CustomerEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id")
   private UUID customerId;

   @Column(length = 11, unique = true, nullable = false)
   private String personalId;

   @Column(unique = true, nullable = false)
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
      return new CustomerResponse(this.getCustomerId(), this.getPersonalId(), this.getEmail(), this.getName());
   }
}