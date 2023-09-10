package com.fiappostech.fastfood.adapter.presenter.customer;

import com.fiappostech.fastfood.adapter.presenter.customer.request.CustomerPostRequest;
import com.fiappostech.fastfood.adapter.presenter.customer.response.CustomerResponseFull;
import com.fiappostech.fastfood.application.usecase.customer.CustomerRegistryUseCase;

public class CustomerRegistryControllerPresenter implements CustomerRegistryPresenter{

   private final CustomerRegistryUseCase customerRegistryUseCase;

   public CustomerRegistryControllerPresenter(CustomerRegistryUseCase customerRegistryUseCase) {
      this.customerRegistryUseCase = customerRegistryUseCase;
   }

   public CustomerResponseFull execute(CustomerPostRequest customerPostRequest) {
      var customerResponse = customerRegistryUseCase.execute(customerPostRequest.toCustomerRequest());
      return new CustomerResponseFull(customerResponse);
   }
}