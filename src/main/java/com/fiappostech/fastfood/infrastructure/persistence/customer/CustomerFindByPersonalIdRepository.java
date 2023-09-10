package com.fiappostech.fastfood.infrastructure.persistence.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.domain.dto.customer.CustomerResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomerFindByPersonalIdRepository{

   @Autowired
   private final CustomerRepository customerRepository;

   @Transactional(readOnly = true)
   public CustomerResponse execute(String personalId) {
      var customerEntity = customerRepository.findByPersonalId(personalId);
      return customerEntity == null ? null : customerEntity.toCustomerResponse();
   }
}