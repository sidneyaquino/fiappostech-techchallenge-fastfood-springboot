package com.fiappostech.fastfood.infrastructure.api.customer;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapter.presenter.customer.CustomerFindByIdPresenter;
import com.fiappostech.fastfood.adapter.presenter.customer.CustomerIdentifyPresenter;
import com.fiappostech.fastfood.adapter.presenter.customer.response.CustomerResponseFull;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Customers") // , description = "the Customer Api")
@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerGetController {

   @Autowired
   private final CustomerFindByIdPresenter customerFindByIdPresenter;
   @Autowired
   private final CustomerIdentifyPresenter customerIdentifyPresenter;

   private static int request = 0;

   @GetMapping("/{customerId}")
   public ResponseEntity<CustomerResponseFull> customerFindBylId(@PathVariable UUID customerId) {
      return ResponseEntity.ok(customerFindByIdPresenter.execute(customerId));
   }

   @GetMapping
   public ResponseEntity<CustomerResponseFull> customerFindByPersonalId(@RequestParam String personalId) throws UnknownHostException {
      System.out.println("\n" + "Request/Thread: " + ++request + " - " +
            InetAddress.getLocalHost().getHostName() + "/" +
            Thread.currentThread().toString());

      return ResponseEntity.ok(customerIdentifyPresenter.execute(personalId));
   }
}