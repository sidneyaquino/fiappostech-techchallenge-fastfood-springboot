package com.fiappostech.fastfood.domain.port.customer;

import com.fiappostech.fastfood.domain.port.customer.dto.CustomerResponse;

public interface CustomerIdentifyUseCase {
   CustomerResponse execute(String personalId);
}