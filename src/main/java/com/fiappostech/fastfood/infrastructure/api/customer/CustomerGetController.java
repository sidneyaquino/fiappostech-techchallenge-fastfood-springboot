package com.fiappostech.fastfood.infrastructure.api.customer;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapter.presenter.customer.CustomerFindByIdPresenter;
import com.fiappostech.fastfood.adapter.presenter.customer.CustomerIdentifyPresenter;
import com.fiappostech.fastfood.adapter.presenter.customer.response.CustomerResponseFull;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerGetController {

   private final CustomerFindByIdPresenter customerFindByIdPresenter;
   private final CustomerIdentifyPresenter customerIdentifyPresenter;
   private static int request = 0;

   @GetMapping("/{customerId}")
   public ResponseEntity<CustomerResponseFull> customerFindBylId(@PathVariable UUID customerId) {
      return ResponseEntity.ok(customerFindByIdPresenter.execute(customerId));
   }

   @GetMapping
   public ResponseEntity<CustomerResponseFull> customerFindByPersonalId(@RequestParam String personalId) throws UnknownHostException {
      System.out.println("Request: " + ++request + " - " + InetAddress.getLocalHost().getHostName() + "\n"); ;      
      return ResponseEntity.ok(customerIdentifyPresenter.execute(personalId));
   }
}