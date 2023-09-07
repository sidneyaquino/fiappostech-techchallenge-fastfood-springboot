package com.fiappostech.fastfood.application.port.customer;

import com.fiappostech.fastfood.domain.port.customer.dto.CustomerRequest;
import com.fiappostech.fastfood.domain.port.customer.dto.CustomerResponse;

public interface CustomerRegistryGateway {
   CustomerResponse execute(CustomerRequest customerRequest);
}