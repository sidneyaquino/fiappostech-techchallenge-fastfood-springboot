package com.fiappostech.fastfood.application.core;

import com.fiappostech.fastfood.application.core.domain.CustomerDomain;
import com.fiappostech.fastfood.application.ports.dto.request.CustomerRequest;
import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;
import com.fiappostech.fastfood.application.ports.inbound.CustomerRegistryInputPort;
import com.fiappostech.fastfood.application.ports.outbound.CustomerRegistryOutputPort;

public class CustomerRegistryUseCase implements CustomerRegistryInputPort {

   private final CustomerRegistryOutputPort customerCreateOutputPort;

   public CustomerRegistryUseCase(CustomerRegistryOutputPort customerCreateOutputPort) {
      this.customerCreateOutputPort = customerCreateOutputPort;
   }

   @Override
   public CustomerResponse execute(CustomerRequest customerRequest) {
      var customerDomain = new CustomerDomain(customerRequest);
      
      //
      // Business Rules before Request.
      //
      var customerResponse = customerCreateOutputPort.execute(customerDomain.toCustomerRequest());
      customerDomain = new CustomerDomain(customerResponse);      
      //
      // Business Rules before Response.
      //

      return customerDomain.toCustomerResponse();
   }
}