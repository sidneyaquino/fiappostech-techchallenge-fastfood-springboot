package com.fiappostech.fastfood.application.core.usecases;

import java.util.UUID;

import com.fiappostech.fastfood.application.core.domain.CustomerDomain;
import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;
import com.fiappostech.fastfood.application.ports.inbound.CustomerFindByIdInputPort;
import com.fiappostech.fastfood.application.ports.outbound.CustomerFindByIdOutputPort;

public class CustomerFindByIdService implements CustomerFindByIdInputPort {

   private final CustomerFindByIdOutputPort customerFindByIdOutputPort;

   public CustomerFindByIdService(CustomerFindByIdOutputPort customerFindByIdOutputPort) {
      this.customerFindByIdOutputPort = customerFindByIdOutputPort;
   }

   @Override
   public CustomerResponse execute(UUID customerId) {

      //
      // Business Rules before Request.
      //
      var customerResponse = this.customerFindByIdOutputPort.execute(customerId);
      var customerDomain = new CustomerDomain(customerResponse);
      //
      // Business Rules before Response.
      //

      return customerDomain.toCustomerResponse();
   }
}