package com.fiappostech.fastfood.adapters.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.repository.CustomerRepository;
import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;
import com.fiappostech.fastfood.application.ports.outbound.CustomerIdentifyOutputPort;
import com.fiappostech.fastfood.config.exception.RecordNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomerFindByPersonalIdRepository implements CustomerIdentifyOutputPort {

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