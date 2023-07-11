package com.fiappostech.fastfood.adapters.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.entity.CustomerEntity;
import com.fiappostech.fastfood.adapters.outbound.repository.CustomerRepository;
import com.fiappostech.fastfood.application.ports.dto.request.CustomerRequest;
import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;
import com.fiappostech.fastfood.application.ports.outbound.CustomerRegistryOutputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomerSaveRepository implements CustomerRegistryOutputPort {

   @Autowired
   private final CustomerRepository customerRepository;

   @Transactional
   @Override
   public CustomerResponse execute(CustomerRequest customerRequest) {
      return customerRepository.save(new CustomerEntity(customerRequest)).toCustomerResponse();
   }
}