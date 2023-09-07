package com.fiappostech.fastfood.application.port.customer;

import java.util.UUID;

import com.fiappostech.fastfood.domain.port.customer.dto.CustomerResponse;

public interface CustomerFindByIdGateway {
   CustomerResponse execute(UUID customerId);
}