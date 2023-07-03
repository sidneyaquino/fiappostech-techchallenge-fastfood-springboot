package com.fiappostech.fastfood.application.ports.outbound;

import com.fiappostech.fastfood.application.ports.dto.request.CustomerRequest;
import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;

public interface CustomerRegistryOutputPort {
   CustomerResponse execute(CustomerRequest customerRequest);
}