package com.fiappostech.fastfood.adapters.outbound.entity;

import com.fiappostech.fastfood.application.ports.dto.request.CustomerRequest;
import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "Customers")
public class CustomerEntity {

   @Id
   @Column(length = 11)
   private String personalId;

   @Column(nullable = false, unique = true)
   private String email;

   @Column(nullable = false)
   private String name;

   public CustomerEntity(CustomerRequest customerRequest) {
      this.personalId = customerRequest.personalId();
      this.email = customerRequest.email();
      this.name = customerRequest.name();
   }

   public CustomerResponse toCustomerResponse() {
      return new CustomerResponse(this.getPersonalId(), this.getEmail(), this.getName());
   }   
}