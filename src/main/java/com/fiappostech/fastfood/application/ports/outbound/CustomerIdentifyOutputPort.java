package com.fiappostech.fastfood.application.ports.outbound;

import com.fiappostech.fastfood.application.ports.dto.Customer;

public interface CustomerIdentifyOutputPort {
   Customer execute(String personalId);
}