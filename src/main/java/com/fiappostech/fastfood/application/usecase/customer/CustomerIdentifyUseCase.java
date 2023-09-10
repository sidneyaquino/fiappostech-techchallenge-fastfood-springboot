package com.fiappostech.fastfood.application.usecase.customer;

import com.fiappostech.fastfood.domain.dto.customer.CustomerResponse;

public interface CustomerIdentifyUseCase {
   CustomerResponse execute(String personalId);
}