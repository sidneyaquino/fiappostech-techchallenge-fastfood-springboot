package com.fiappostech.fastfood.adapter.gateway.customer;

import com.fiappostech.fastfood.domain.dto.customer.CustomerResponse;
import com.fiappostech.fastfood.infrastructure.persistence.customer.CustomerFindByPersonalIdRepository;

public class CustomerIdentifyRepositoryGateway implements CustomerIdentifyGateway {

   private final CustomerFindByPersonalIdRepository customerFindByPersonalIdRepository;

   public CustomerIdentifyRepositoryGateway(CustomerFindByPersonalIdRepository customerFindByPersonalIdRepository) {
      this.customerFindByPersonalIdRepository = customerFindByPersonalIdRepository;
   }

   @Override
   public CustomerResponse execute(String personalId) {
      return customerFindByPersonalIdRepository.execute(personalId);
   }
}