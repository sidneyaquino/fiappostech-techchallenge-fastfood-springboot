package com.fiappostech.fastfood.adapters.outbound;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.repository.CustomerRepository;
import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;
import com.fiappostech.fastfood.application.ports.outbound.CustomerFindByIdOutputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomerFindByIdRepository implements CustomerFindByIdOutputPort {

   @Autowired
   private final CustomerRepository customerRepository;

   @Transactional(readOnly = true)
   @Override
   public CustomerResponse execute(UUID customerId) {
      return customerRepository.getReferenceById(customerId).toCustomerResponse();
   }
}