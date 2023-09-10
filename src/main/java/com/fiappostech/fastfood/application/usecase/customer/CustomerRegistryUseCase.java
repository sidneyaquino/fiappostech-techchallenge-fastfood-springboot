package com.fiappostech.fastfood.application.usecase.customer;

import com.fiappostech.fastfood.domain.dto.customer.CustomerRequest;
import com.fiappostech.fastfood.domain.dto.customer.CustomerResponse;

public interface CustomerRegistryUseCase {
   CustomerResponse execute(CustomerRequest customerRequest);
}