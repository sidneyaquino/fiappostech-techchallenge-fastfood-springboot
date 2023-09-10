package com.fiappostech.fastfood.application.usecase.customer;

import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.customer.CustomerResponse;

public interface CustomerFindByIdUseCase {
   CustomerResponse execute(UUID customerId);
}