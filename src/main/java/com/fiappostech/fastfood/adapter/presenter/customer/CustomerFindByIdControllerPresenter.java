package com.fiappostech.fastfood.adapter.presenter.customer;

import java.util.UUID;

import com.fiappostech.fastfood.adapter.presenter.customer.response.CustomerResponseFull;
import com.fiappostech.fastfood.application.usecase.customer.CustomerFindByIdUseCase;

public class CustomerFindByIdControllerPresenter implements CustomerFindByIdPresenter{

   private final CustomerFindByIdUseCase customerFindByIdUseCase;

   public CustomerFindByIdControllerPresenter(CustomerFindByIdUseCase customerFindByIdUseCase) {
      this.customerFindByIdUseCase = customerFindByIdUseCase;
   }

   @Override
   public CustomerResponseFull execute(UUID customerId) {
      var customerResponse = customerFindByIdUseCase.execute(customerId);
      return new CustomerResponseFull(customerResponse);
   }
}