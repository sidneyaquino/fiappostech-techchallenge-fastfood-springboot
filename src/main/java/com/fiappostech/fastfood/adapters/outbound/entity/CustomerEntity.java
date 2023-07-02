package com.fiappostech.fastfood.adapters.outbound.entity;

import com.fiappostech.fastfood.application.ports.dto.Customer;

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
   private String personalId;

   @Column(unique = true)
   private String email;

   @Column(nullable = false)
   private String name;

   public CustomerEntity(Customer customer) {
      this.personalId = customer.personalId();
      this.email = customer.email();
      this.name = customer.name();
   }

   public Customer toCustomer() {
      return new Customer(this.getPersonalId(), this.getEmail(), this.getName());
   }   
}