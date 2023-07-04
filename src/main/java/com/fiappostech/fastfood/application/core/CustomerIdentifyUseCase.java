package com.fiappostech.fastfood.application.core;

import com.fiappostech.fastfood.application.core.domain.CustomerDomain;
import com.fiappostech.fastfood.application.core.valueobject.PersonalIdDomain;
import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;
import com.fiappostech.fastfood.application.ports.inbound.CustomerIdentifyInputPort;
import com.fiappostech.fastfood.application.ports.outbound.CustomerIdentifyOutputPort;

public class CustomerIdentifyUseCase implements CustomerIdentifyInputPort {

   private final CustomerIdentifyOutputPort customerIdentifyAdapterPort;

   public CustomerIdentifyUseCase(CustomerIdentifyOutputPort customerIdentifyOutputPort) {
      this.customerIdentifyAdapterPort = customerIdentifyOutputPort;
   }

   @Override
   public CustomerResponse execute(String personalId) {
      var personalIdDomain = new PersonalIdDomain(personalId);

      //
      // Business Rules before Request.
      //
      var customerResponse = this.customerIdentifyAdapterPort.execute(personalIdDomain.personalId());
      var customerDomain = new CustomerDomain(customerResponse);      
      //
      // Business Rules before Response.
      //

      return customerDomain.toCustomerResponse();
   }
}