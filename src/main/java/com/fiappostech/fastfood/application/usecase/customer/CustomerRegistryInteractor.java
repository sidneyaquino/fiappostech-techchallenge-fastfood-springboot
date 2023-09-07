package com.fiappostech.fastfood.application.usecase.customer;

import org.springframework.dao.DataIntegrityViolationException;

import com.fiappostech.fastfood.application.exception.BusinessException;
import com.fiappostech.fastfood.application.port.customer.CustomerRegistryGateway;
import com.fiappostech.fastfood.domain.entity.CustomerDomain;
import com.fiappostech.fastfood.domain.port.customer.CustomerRegistryUseCase;
import com.fiappostech.fastfood.domain.port.customer.dto.CustomerRequest;
import com.fiappostech.fastfood.domain.port.customer.dto.CustomerResponse;

public class CustomerRegistryInteractor implements CustomerRegistryUseCase {

   private final CustomerRegistryGateway customerRegistryGateway;

   public CustomerRegistryInteractor(CustomerRegistryGateway customerRegistryGateway) {
      this.customerRegistryGateway = customerRegistryGateway;
   }

   @Override
   public CustomerResponse execute(CustomerRequest customerRequest) {
      var customerDomain = new CustomerDomain(customerRequest);

      //
      // Business Rules before Request.
      //
      try {
         var customerResponse = this.customerRegistryGateway.execute(customerDomain.toCustomerRequest());
         customerDomain = new CustomerDomain(customerResponse);         
      } catch (DataIntegrityViolationException e) {
         throw new BusinessException("Personal ID already exists");
      }
      //
      // Business Rules before Response.
      //

      return customerDomain.toCustomerResponse();
   }
}