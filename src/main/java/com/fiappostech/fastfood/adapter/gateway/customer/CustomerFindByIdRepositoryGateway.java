package com.fiappostech.fastfood.adapter.gateway.customer;

import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.customer.CustomerResponse;
import com.fiappostech.fastfood.infrastructure.persistence.customer.CustomerFindByIdRepository;

public class CustomerFindByIdRepositoryGateway implements CustomerFindByIdGateway {

   private final CustomerFindByIdRepository customerFindByIdRepository;

   public CustomerFindByIdRepositoryGateway(CustomerFindByIdRepository customerFindByIdRepository) {
      this.customerFindByIdRepository = customerFindByIdRepository;
   }

   @Override
   public CustomerResponse execute(UUID customerId) {
      return customerFindByIdRepository.execute(customerId);
   }
}