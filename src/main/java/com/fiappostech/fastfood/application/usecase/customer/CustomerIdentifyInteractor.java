package com.fiappostech.fastfood.application.usecase.customer;

import com.fiappostech.fastfood.adapter.gateway.customer.CustomerIdentifyGateway;
import com.fiappostech.fastfood.domain.dto.customer.CustomerResponse;
import com.fiappostech.fastfood.domain.entity.CustomerDomain;
import com.fiappostech.fastfood.domain.valueobject.PersonalIdDomain;

public class CustomerIdentifyInteractor implements CustomerIdentifyUseCase {

   private final CustomerIdentifyGateway customerIdentifyGateway;

   public CustomerIdentifyInteractor(CustomerIdentifyGateway customerIdentifyGateway) {
      this.customerIdentifyGateway = customerIdentifyGateway;
   }

   @Override
   public CustomerResponse execute(String personalId) {

      //
      // Business Rules before Request.
      //
      PersonalIdDomain personalIdDomain = new PersonalIdDomain(personalId);

      //
      // Request.
      //
      var customerResponse = this.customerIdentifyGateway.execute(personalIdDomain.personalId());
      var customerDomain = new CustomerDomain(customerResponse);
      
      //
      // Business Rules before Response.
      //

      return customerDomain.toCustomerResponse();
   }
}