package com.fiappostech.fastfood.adapter.gateway.customer;

import com.fiappostech.fastfood.domain.dto.customer.CustomerRequest;
import com.fiappostech.fastfood.domain.dto.customer.CustomerResponse;
import com.fiappostech.fastfood.infrastructure.persistence.customer.CustomerSaveRepository;

public class CustomerRegistryRepositoryGateway implements CustomerRegistryGateway {

   private final CustomerSaveRepository customerSaveRepository;

   public CustomerRegistryRepositoryGateway(CustomerSaveRepository customerSaveRepository) {
      this.customerSaveRepository = customerSaveRepository;
   }

   @Override
   public CustomerResponse execute(CustomerRequest customerRequest) {
      return customerSaveRepository.execute(customerRequest);
   }
}