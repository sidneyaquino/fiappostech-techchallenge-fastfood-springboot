package com.fiappostech.fastfood.application.core.usecase;

import com.fiappostech.fastfood.application.core.domain.CustomerDomain;
import com.fiappostech.fastfood.application.ports.dto.Customer;
import com.fiappostech.fastfood.application.ports.inbound.CustomerCreateInputPort;
import com.fiappostech.fastfood.application.ports.outbound.CustomerCreateOutputPort;

public class CustomerCreateUseCase implements CustomerCreateInputPort {

   private final CustomerCreateOutputPort customerCreateOutputPort;

   public CustomerCreateUseCase(CustomerCreateOutputPort customerCreateOutputPort) {
      this.customerCreateOutputPort = customerCreateOutputPort;
   }

   @Override
   public Customer execute(Customer request) {
      var customerDomain = new CustomerDomain(request);
      
      // Business Roles.

      return customerCreateOutputPort.execute(customerDomain.toCustomer());
   }
}