package com.fiappostech.fastfood.application.port.customer;

import com.fiappostech.fastfood.domain.port.customer.dto.CustomerResponse;

public interface CustomerIdentifyGateway {
   CustomerResponse execute(String personalId);
}