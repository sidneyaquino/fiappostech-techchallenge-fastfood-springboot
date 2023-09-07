package com.fiappostech.fastfood.application.usecase.customer;

import java.util.UUID;

import com.fiappostech.fastfood.application.port.customer.CustomerFindByIdGateway;
import com.fiappostech.fastfood.domain.entity.CustomerDomain;
import com.fiappostech.fastfood.domain.port.customer.CustomerFindByIdUseCase;
import com.fiappostech.fastfood.domain.port.customer.dto.CustomerResponse;

public class CustomerFindByIdInteractor implements CustomerFindByIdUseCase {

   private final CustomerFindByIdGateway customerFindByIdGateway;

   public CustomerFindByIdInteractor(CustomerFindByIdGateway customerFindByIdGateway) {
      this.customerFindByIdGateway = customerFindByIdGateway;
   }

   @Override
   public CustomerResponse execute(UUID customerId) {

      //
      // Business Rules before Request.
      //
      var customerResponse = this.customerFindByIdGateway.execute(customerId);
      var customerDomain = new CustomerDomain(customerResponse);
      //
      // Business Rules before Response.
      //

      return customerDomain.toCustomerResponse();
   }
}