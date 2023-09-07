package com.fiappostech.fastfood.infrastructure.persistence.customer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.application.port.customer.CustomerFindByIdGateway;
import com.fiappostech.fastfood.domain.port.customer.dto.CustomerResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomerFindByIdRepository implements CustomerFindByIdGateway {

   @Autowired
   private final CustomerRepository customerRepository;

   @Transactional(readOnly = true)
   @Override
   public CustomerResponse execute(UUID customerId) {
      return customerRepository.getReferenceById(customerId).toCustomerResponse();
   }
}