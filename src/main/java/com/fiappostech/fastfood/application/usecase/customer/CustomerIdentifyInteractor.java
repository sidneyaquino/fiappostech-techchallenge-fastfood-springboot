package com.fiappostech.fastfood.application.usecase.customer;

import com.fiappostech.fastfood.application.port.customer.CustomerIdentifyGateway;
import com.fiappostech.fastfood.domain.entity.CustomerDomain;
import com.fiappostech.fastfood.domain.port.customer.CustomerIdentifyUseCase;
import com.fiappostech.fastfood.domain.port.customer.dto.CustomerResponse;
import com.fiappostech.fastfood.domain.valueobject.PersonalIdDomain;

public class CustomerIdentifyInteractor implements CustomerIdentifyUseCase {

   private final CustomerIdentifyGateway customerIdentifyGateway;

   public CustomerIdentifyInteractor(CustomerIdentifyGateway customerIdentifyGateway) {
      this.customerIdentifyGateway = customerIdentifyGateway;
   }

   @Override
   public CustomerResponse execute(String personalId) {
      var personalIdDomain = new PersonalIdDomain(personalId);

      //
      // Business Rules before Request.
      //
      var customerResponse = this.customerIdentifyGateway.execute(personalIdDomain.personalId());
      var customerDomain = new CustomerDomain(customerResponse);      
      //
      // Business Rules before Response.
      //

      return customerDomain.toCustomerResponse();
   }
}