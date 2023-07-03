package com.fiappostech.fastfood.application.ports.outbound;

import com.fiappostech.fastfood.application.ports.dto.response.CustomerResponse;

public interface CustomerIdentifyOutputPort {
   CustomerResponse execute(String personalId);
}