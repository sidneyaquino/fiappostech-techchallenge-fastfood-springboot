package com.fiappostech.fastfood.adapters.inbound;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapters.inbound.dto.response.CustomerFullResponse;
import com.fiappostech.fastfood.application.ports.inbound.CustomerIdentifyInputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerGetControllerAdapter {

   private final CustomerIdentifyInputPort customerIdentifyInputPort;

   @GetMapping("/{personalId}")
   public ResponseEntity<CustomerFullResponse> customerFindById(@PathVariable String personalId) {
      
      var customerResponse = customerIdentifyInputPort.execute(personalId);
      return ResponseEntity.ok(new CustomerFullResponse(customerResponse));
   }
}