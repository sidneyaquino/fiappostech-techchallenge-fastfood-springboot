package com.fiappostech.fastfood.adapter.presenter.customer;

import com.fiappostech.fastfood.adapter.presenter.customer.response.CustomerResponseFull;
import com.fiappostech.fastfood.application.usecase.customer.CustomerIdentifyUseCase;

public class CustomerIdentifyControllerPresenter implements CustomerIdentifyPresenter{

   private final CustomerIdentifyUseCase customerIdentifyUseCase;

   public CustomerIdentifyControllerPresenter(CustomerIdentifyUseCase customerIdentifyUseCase) {
      this.customerIdentifyUseCase = customerIdentifyUseCase;
   }

   public CustomerResponseFull execute(String personalId) {
      var customerResponse = customerIdentifyUseCase.execute(personalId);
      return new CustomerResponseFull(customerResponse);
   }
}