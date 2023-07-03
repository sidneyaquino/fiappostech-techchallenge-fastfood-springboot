package com.fiappostech.fastfood.application.ports.inbound;

import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;

public interface CustomerIdentifyInputPort {
   CustomerResponse execute(String personalId);
}