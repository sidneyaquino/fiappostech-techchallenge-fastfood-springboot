package com.fiappostech.fastfood.application.core.usecases;

import org.springframework.dao.DataIntegrityViolationException;

import com.fiappostech.fastfood.application.core.domain.CustomerDomain;
import com.fiappostech.fastfood.application.ports.dto.request.CustomerRequest;
import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;
import com.fiappostech.fastfood.application.ports.exception.ApplicationException;
import com.fiappostech.fastfood.application.ports.inbound.CustomerRegistryInputPort;
import com.fiappostech.fastfood.application.ports.outbound.CustomerRegistryOutputPort;

public class CustomerRegistryService implements CustomerRegistryInputPort {

   private final CustomerRegistryOutputPort customerRegistryOutputPort;

   public CustomerRegistryService(CustomerRegistryOutputPort customerRegistryOutputPort) {
      this.customerRegistryOutputPort = customerRegistryOutputPort;
   }

   @Override
   public CustomerResponse execute(CustomerRequest customerRequest) {
      var customerDomain = new CustomerDomain(customerRequest);

      //
      // Business Rules before Request.
      //
      try {
         var customerResponse = this.customerRegistryOutputPort.execute(customerDomain.toCustomerRequest());
         customerDomain = new CustomerDomain(customerResponse);         
      } catch (DataIntegrityViolationException e) {
         throw new ApplicationException("Personal ID already exists");
      }
      //
      // Business Rules before Response.
      //

      return customerDomain.toCustomerResponse();
   }
}