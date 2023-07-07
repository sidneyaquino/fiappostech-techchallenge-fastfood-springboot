package com.fiappostech.fastfood.application.ports.outbound;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;

public interface CustomerFindByIdOutputPort {
   CustomerResponse execute(UUID customerId);
}