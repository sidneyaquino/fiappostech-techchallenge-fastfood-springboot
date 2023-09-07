package com.fiappostech.fastfood.infrastructure.persistence.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.application.port.customer.CustomerRegistryGateway;
import com.fiappostech.fastfood.domain.port.customer.dto.CustomerRequest;
import com.fiappostech.fastfood.domain.port.customer.dto.CustomerResponse;
import com.fiappostech.fastfood.infrastructure.persistence.customer.entity.CustomerEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomerSaveRepository implements CustomerRegistryGateway {

   @Autowired
   private final CustomerRepository customerRepository;

   @Transactional
   @Override
   public CustomerResponse execute(CustomerRequest customerRequest) {
      return customerRepository.save(new CustomerEntity(customerRequest)).toCustomerResponse();
   }
}