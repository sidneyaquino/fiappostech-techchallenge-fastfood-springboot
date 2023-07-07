package com.fiappostech.fastfood.application.core;

import java.util.UUID;

import com.fiappostech.fastfood.application.core.domain.CustomerDomain;
import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;
import com.fiappostech.fastfood.application.ports.inbound.CustomerFindByIdInputPort;
import com.fiappostech.fastfood.application.ports.outbound.CustomerFindByIdOutputPort;

public class CustomerFindByIdUseCase implements CustomerFindByIdInputPort {

   private final CustomerFindByIdOutputPort customerFindByIdAdapterPort;

   public CustomerFindByIdUseCase(CustomerFindByIdOutputPort customerFindByIdAdapterPort) {
      this.customerFindByIdAdapterPort = customerFindByIdAdapterPort;
   }

   @Override
   public CustomerResponse execute(UUID customerId) {

      //
      // Business Rules before Request.
      //
      var customerResponse = this.customerFindByIdAdapterPort.execute(customerId);
      var customerDomain = new CustomerDomain(customerResponse);
      //
      // Business Rules before Response.
      //

      return customerDomain.toCustomerResponse();
   }
}