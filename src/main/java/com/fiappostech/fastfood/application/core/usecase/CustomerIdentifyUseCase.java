package com.fiappostech.fastfood.application.core.usecase;

import com.fiappostech.fastfood.application.ports.dto.Customer;
import com.fiappostech.fastfood.application.ports.inbound.CustomerIdentifyInputPort;
import com.fiappostech.fastfood.application.ports.outbound.CustomerIdentifyOutputPort;

public class CustomerIdentifyUseCase implements CustomerIdentifyInputPort {

   private final CustomerIdentifyOutputPort customerIdentifyAdapterPort;

   public CustomerIdentifyUseCase(CustomerIdentifyOutputPort customerIdentifyOutputPort) {
      this.customerIdentifyAdapterPort = customerIdentifyOutputPort;
   }

   @Override
   public Customer execute(String personalId) {
      return customerIdentifyAdapterPort.execute(personalId);
   }
}