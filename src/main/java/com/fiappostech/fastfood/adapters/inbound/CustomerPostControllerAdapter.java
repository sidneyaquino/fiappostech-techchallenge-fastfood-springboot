package com.fiappostech.fastfood.adapters.inbound;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiappostech.fastfood.adapters.inbound.dto.request.CustomerPostRequest;
import com.fiappostech.fastfood.adapters.inbound.dto.response.CustomerFullResponse;
import com.fiappostech.fastfood.application.ports.inbound.CustomerRegistryInputPort;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerPostControllerAdapter {

   private final CustomerRegistryInputPort customerRegistryInputPort;

   @PostMapping
   public ResponseEntity<CustomerFullResponse> customerSave(
         @RequestBody @Valid CustomerPostRequest customerPostRequest,
         UriComponentsBuilder uriComponentsBuilder) {

      var customerResponse = customerRegistryInputPort.execute(customerPostRequest.toCustomerRequest());
      var uri = uriComponentsBuilder
            .path("/customers/{personalId}")
            .buildAndExpand(customerResponse.personalId())
            .toUri();

      return ResponseEntity.created(uri).body(new CustomerFullResponse(customerResponse));
   }
}