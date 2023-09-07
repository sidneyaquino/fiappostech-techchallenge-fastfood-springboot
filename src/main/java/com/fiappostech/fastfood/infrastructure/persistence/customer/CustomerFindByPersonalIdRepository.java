package com.fiappostech.fastfood.infrastructure.persistence.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.application.port.customer.CustomerIdentifyGateway;
import com.fiappostech.fastfood.domain.port.customer.dto.CustomerResponse;
import com.fiappostech.fastfood.infrastructure.exception.RecordNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomerFindByPersonalIdRepository implements CustomerIdentifyGateway {

   @Autowired
   private final CustomerRepository customerRepository;

   @Transactional(readOnly = true)
   @Override
   public CustomerResponse execute(String personalId) {
      var customerEntity = customerRepository.findByPersonalId(personalId);

      if(customerEntity == null) {
         throw new RecordNotFoundException(personalId);
      }
      return customerEntity.toCustomerResponse();
   }
}