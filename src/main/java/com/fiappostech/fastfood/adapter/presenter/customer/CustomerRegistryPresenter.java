package com.fiappostech.fastfood.adapter.presenter.customer;

import com.fiappostech.fastfood.adapter.presenter.customer.request.CustomerPostRequest;
import com.fiappostech.fastfood.adapter.presenter.customer.response.CustomerResponseFull;
import com.fiappostech.fastfood.domain.port.customer.CustomerRegistryUseCase;

public class CustomerRegistryPresenter {

   private final CustomerRegistryUseCase customerRegistryUseCase;

   public CustomerRegistryPresenter(CustomerRegistryUseCase customerRegistryUseCase) {
      this.customerRegistryUseCase = customerRegistryUseCase;
   }

   public CustomerResponseFull execute(CustomerPostRequest customerPostRequest) {
      var customerResponse = customerRegistryUseCase.execute(customerPostRequest.toCustomerRequest());
      return new CustomerResponseFull(customerResponse);
   }
}