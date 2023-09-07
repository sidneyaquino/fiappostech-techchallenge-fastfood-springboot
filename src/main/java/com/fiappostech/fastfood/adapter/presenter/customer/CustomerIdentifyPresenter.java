package com.fiappostech.fastfood.adapter.presenter.customer;

import com.fiappostech.fastfood.adapter.presenter.customer.response.CustomerResponseFull;
import com.fiappostech.fastfood.domain.port.customer.CustomerIdentifyUseCase;

public class CustomerIdentifyPresenter {

   private final CustomerIdentifyUseCase customerIdentifyUseCase;

   public CustomerIdentifyPresenter(CustomerIdentifyUseCase customerIdentifyUseCase) {
      this.customerIdentifyUseCase = customerIdentifyUseCase;
   }

   public CustomerResponseFull execute(String personalId) {
      var customerResponse = customerIdentifyUseCase.execute(personalId);
      return new CustomerResponseFull(customerResponse);
   }
}