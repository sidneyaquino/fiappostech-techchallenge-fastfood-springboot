package com.fiappostech.fastfood.domain.port.customer;

import com.fiappostech.fastfood.domain.port.customer.dto.CustomerRequest;
import com.fiappostech.fastfood.domain.port.customer.dto.CustomerResponse;

public interface CustomerRegistryUseCase {
   CustomerResponse execute(CustomerRequest customerRequest);
}