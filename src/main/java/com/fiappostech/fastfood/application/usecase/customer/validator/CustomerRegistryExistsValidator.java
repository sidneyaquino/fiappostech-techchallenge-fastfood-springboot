package com.fiappostech.fastfood.application.usecase.customer.validator;

import com.fiappostech.fastfood.adapter.gateway.customer.CustomerIdentifyGateway;
import com.fiappostech.fastfood.application.exception.ApplicationException;
import com.fiappostech.fastfood.domain.dto.customer.CustomerRequest;
import com.fiappostech.fastfood.domain.dto.customer.CustomerResponse;

public class CustomerRegistryExistsValidator implements CustomerRegistryValidator{
   
   private final CustomerIdentifyGateway customerIdentifyGateway;
   
   public CustomerRegistryExistsValidator(CustomerIdentifyGateway customerIdentifyGateway){
      this.customerIdentifyGateway = customerIdentifyGateway;
   }

   public void validate(CustomerRequest customerRequest){
      CustomerResponse customerResponse = this.customerIdentifyGateway.execute(customerRequest.personalId());
      if(customerResponse != null){
         throw new ApplicationException("Customer already exists");
      }
   };
}