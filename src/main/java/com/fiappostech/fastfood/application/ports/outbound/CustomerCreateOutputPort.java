package com.fiappostech.fastfood.application.ports.outbound;

import com.fiappostech.fastfood.application.ports.dto.Customer;

public interface CustomerCreateOutputPort {
   Customer execute(Customer customer);
}