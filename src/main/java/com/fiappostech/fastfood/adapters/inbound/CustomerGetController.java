package com.fiappostech.fastfood.adapters.inbound;

import java.net.InetAddress;
import java.net.UnknownHostException;
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
public class CustomerGetController {

   private final CustomerFindByIdInputPort customerFindByIdInputPort;
   private final CustomerIdentifyInputPort customerIdentifyInputPort;
   private static int request = 0;

   @GetMapping("/{customerId}")
   public ResponseEntity<CustomerFullResponse> customerFindBylId(@PathVariable UUID customerId) {
      var customerResponse = customerFindByIdInputPort.execute(customerId);
      return ResponseEntity.ok(new CustomerFullResponse(customerResponse));
   }

   @GetMapping
   public ResponseEntity<CustomerFullResponse> customerFindByPersonalId(@RequestParam String personalId) throws UnknownHostException {
      System.out.println("Request: " + ++request + " - " + InetAddress.getLocalHost().getHostName() + "\n");
      var customerResponse = customerIdentifyInputPort.execute(personalId);
      return ResponseEntity.ok(new CustomerFullResponse(customerResponse));
   }
}