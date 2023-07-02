package com.fiappostech.fastfood.application.ports.inbound;

import com.fiappostech.fastfood.application.ports.dto.Customer;

public interface CustomerCreateInputPort {
   Customer execute(Customer customer);
}