package com.fiappostech.fastfood.adapters.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.repository.CustomerRepository;
import com.fiappostech.fastfood.application.ports.dto.Customer;
import com.fiappostech.fastfood.application.ports.outbound.CustomerIdentifyOutputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomerIdentifyServiceAdapter implements CustomerIdentifyOutputPort {

   @Autowired
   private final CustomerRepository customerRepository;

   @Transactional(readOnly = true)
   @Override
   public Customer execute(String personalId) {

      try {
         return customerRepository.getReferenceById(personalId).toCustomer();
      } catch (Exception e) {
         // throw new NotFoundException(personalId);
         throw e;
      }
   }
}