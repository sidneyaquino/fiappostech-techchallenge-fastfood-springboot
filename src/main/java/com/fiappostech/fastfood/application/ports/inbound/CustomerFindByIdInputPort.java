package com.fiappostech.fastfood.application.ports.inbound;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;

public interface CustomerFindByIdInputPort {
   CustomerResponse execute(UUID customerId);
}