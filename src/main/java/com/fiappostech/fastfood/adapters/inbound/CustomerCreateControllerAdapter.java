package com.fiappostech.fastfood.adapters.inbound;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapters.inbound.request.CustomerRequest;
import com.fiappostech.fastfood.adapters.inbound.response.CustomerResponse;
import com.fiappostech.fastfood.application.ports.inbound.CustomerCreateInputPort;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerCreateControllerAdapter {

   private final CustomerCreateInputPort customerCreateUseCasePort;

   @PostMapping
   public ResponseEntity<CustomerResponse> saveCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
      try {
         var customer = customerCreateUseCasePort.execute(customerRequest.toCustomer());
         return ResponseEntity.status(HttpStatus.CREATED).body(new CustomerResponse(customer));

      } catch (DataIntegrityViolationException e) {
         return ResponseEntity.status(HttpStatus.CONFLICT).build();

      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
   }
}