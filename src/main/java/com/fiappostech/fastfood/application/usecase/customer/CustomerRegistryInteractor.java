package com.fiappostech.fastfood.application.usecase.customer;

import java.util.List;

import com.fiappostech.fastfood.adapter.gateway.customer.CustomerRegistryGateway;
import com.fiappostech.fastfood.application.usecase.customer.validator.CustomerRegistryValidator;
import com.fiappostech.fastfood.domain.dto.customer.CustomerRequest;
import com.fiappostech.fastfood.domain.dto.customer.CustomerResponse;
import com.fiappostech.fastfood.domain.entity.CustomerDomain;

public class CustomerRegistryInteractor implements CustomerRegistryUseCase {

   private final CustomerRegistryGateway customerRegistryGateway;
   private final List<CustomerRegistryValidator> listCustomerRegistryValidator;

   public CustomerRegistryInteractor(
         CustomerRegistryGateway customerRegistryGateway,
         List<CustomerRegistryValidator> listCustomerRegistryValidator)
   
   {
      this.customerRegistryGateway = customerRegistryGateway;
      this.listCustomerRegistryValidator = listCustomerRegistryValidator;
   }

   @Override
   public CustomerResponse execute(CustomerRequest customerRequest) {

      //
      // Business Rules before Request.
      //
      listCustomerRegistryValidator.forEach(item -> item.validate(customerRequest));
      var customerDomain = new CustomerDomain(customerRequest);

      //
      // Request.
      //
      var customerResponse = this.customerRegistryGateway.execute(customerDomain.toCustomerRequest());
      customerDomain = new CustomerDomain(customerResponse);

      //
      // Business Rules before Response.
      //

      return customerDomain.toCustomerResponse();
   }
}