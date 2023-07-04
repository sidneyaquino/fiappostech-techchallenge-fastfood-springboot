package com.fiappostech.fastfood.application.core;

import com.fiappostech.fastfood.application.core.domain.CustomerDomain;
import com.fiappostech.fastfood.application.ports.dto.request.CustomerRequest;
import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;
import com.fiappostech.fastfood.application.ports.inbound.CustomerRegistryInputPort;
import com.fiappostech.fastfood.application.ports.outbound.CustomerRegistryOutputPort;

public class CustomerRegistryUseCase implements CustomerRegistryInputPort {

   private final CustomerRegistryOutputPort customerRegistryOutputPort;

   public CustomerRegistryUseCase(CustomerRegistryOutputPort customerRegistryOutputPort) {
      this.customerRegistryOutputPort = customerRegistryOutputPort;
   }

   @Override
   public CustomerResponse execute(CustomerRequest customerRequest) {
      var customerDomain = new CustomerDomain(customerRequest);
      
      //
      // Business Rules before Request.
      //
      var customerResponse = this.customerRegistryOutputPort.execute(customerDomain.toCustomerRequest());
      customerDomain = new CustomerDomain(customerResponse);      
      //
      // Business Rules before Response.
      //

      return customerDomain.toCustomerResponse();
   }
}