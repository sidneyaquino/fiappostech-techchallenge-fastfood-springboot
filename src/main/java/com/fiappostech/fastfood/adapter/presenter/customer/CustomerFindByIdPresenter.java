package com.fiappostech.fastfood.adapter.presenter.customer;

import java.util.UUID;

import com.fiappostech.fastfood.adapter.presenter.customer.response.CustomerResponseFull;
import com.fiappostech.fastfood.domain.port.customer.CustomerFindByIdUseCase;

public class CustomerFindByIdPresenter {

   private final CustomerFindByIdUseCase customerFindByIdUseCase;

   public CustomerFindByIdPresenter(CustomerFindByIdUseCase customerFindByIdUseCase) {
      this.customerFindByIdUseCase = customerFindByIdUseCase;
   }

   public CustomerResponseFull execute(UUID customerId) {
      var customerResponse = customerFindByIdUseCase.execute(customerId);
      return new CustomerResponseFull(customerResponse);
   }
}