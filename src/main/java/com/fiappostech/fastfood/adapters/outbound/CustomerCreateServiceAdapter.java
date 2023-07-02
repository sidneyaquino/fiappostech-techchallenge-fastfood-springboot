package com.fiappostech.fastfood.adapters.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.entity.CustomerEntity;
import com.fiappostech.fastfood.adapters.outbound.repository.CustomerRepository;
import com.fiappostech.fastfood.application.ports.dto.Customer;
import com.fiappostech.fastfood.application.ports.outbound.CustomerCreateOutputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomerCreateServiceAdapter implements CustomerCreateOutputPort {

   @Autowired
   private final CustomerRepository customerRepository;

   @Transactional
   @Override
   public Customer execute(Customer customer) {
      try {
         return customerRepository.save(new CustomerEntity(customer)).toCustomer();
      } catch (Exception e) {
         throw e;
      }
   }
}