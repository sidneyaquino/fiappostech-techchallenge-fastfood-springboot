package com.fiappostech.fastfood.application.ports.inbound;

import com.fiappostech.fastfood.application.ports.dto.request.CustomerRequest;
import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;

public interface CustomerRegistryInputPort {
   CustomerResponse execute(CustomerRequest customerRequest);
}