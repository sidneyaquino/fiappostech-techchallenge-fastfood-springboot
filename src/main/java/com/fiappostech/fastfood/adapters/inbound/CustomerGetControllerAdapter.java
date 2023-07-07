package com.fiappostech.fastfood.adapters.inbound;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapters.inbound.dto.response.CustomerFullResponse;
import com.fiappostech.fastfood.application.ports.inbound.CustomerFindByIdInputPort;
import com.fiappostech.fastfood.application.ports.inbound.CustomerIdentifyInputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerGetControllerAdapter {

   private final CustomerFindByIdInputPort customerFindByIdInputPort;
   private final CustomerIdentifyInputPort customerIdentifyInputPort;

   @GetMapping("/{customerId}")
   public ResponseEntity<CustomerFullResponse> customerFindByPersonalId(@PathVariable UUID customerId) {
      var customerResponse = customerFindByIdInputPort.execute(customerId);
      return ResponseEntity.ok(new CustomerFullResponse(customerResponse));
   }

   @GetMapping
   public ResponseEntity<CustomerFullResponse> customerFindByPersonalId(@RequestParam String personalId) {
      var customerResponse = customerIdentifyInputPort.execute(personalId);
      return ResponseEntity.ok(new CustomerFullResponse(customerResponse));
   }
}