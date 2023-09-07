package com.fiappostech.fastfood.domain.port.customer;

import java.util.UUID;

import com.fiappostech.fastfood.domain.port.customer.dto.CustomerResponse;

public interface CustomerFindByIdUseCase {
   CustomerResponse execute(UUID customerId);
}