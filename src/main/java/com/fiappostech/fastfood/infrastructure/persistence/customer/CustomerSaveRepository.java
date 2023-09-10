package com.fiappostech.fastfood.infrastructure.persistence.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.domain.dto.customer.CustomerRequest;
import com.fiappostech.fastfood.domain.dto.customer.CustomerResponse;
import com.fiappostech.fastfood.infrastructure.persistence.customer.entity.CustomerEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomerSaveRepository {

   @Autowired
   private final CustomerRepository customerRepository;

   @Transactional
   public CustomerResponse execute(CustomerRequest customerRequest) {
      return customerRepository.save(new CustomerEntity(customerRequest)).toCustomerResponse();
   }
}