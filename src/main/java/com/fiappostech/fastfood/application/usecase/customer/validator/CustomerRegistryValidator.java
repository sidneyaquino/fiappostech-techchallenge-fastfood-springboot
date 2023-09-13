package com.fiappostech.fastfood.application.usecase.customer.validator;

import com.fiappostech.fastfood.domain.dto.customer.CustomerRequest;

public interface CustomerRegistryValidator{
   public void validate(CustomerRequest customerRequest);
}
