package com.fiappostech.fastfood.infrastructure.api.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiappostech.fastfood.adapter.presenter.customer.CustomerRegistryPresenter;
import com.fiappostech.fastfood.adapter.presenter.customer.request.CustomerPostRequest;
import com.fiappostech.fastfood.adapter.presenter.customer.response.CustomerResponseFull;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(name = "Customers") //, description = "the Customer Api")
@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerPostController {

   @Autowired
   private final CustomerRegistryPresenter customerRegistryPresenter;

   @PostMapping
   public ResponseEntity<CustomerResponseFull> customerSave(
         @RequestBody @Valid CustomerPostRequest customerPostRequest,
         UriComponentsBuilder uriComponentsBuilder) {

      var customerResponseFull = customerRegistryPresenter.execute(customerPostRequest);
      var uri = uriComponentsBuilder
            .path("/customers/{personalId}")
            .buildAndExpand(customerResponseFull.customerId())
            .toUri();

      return ResponseEntity.created(uri).body(customerResponseFull);
   }
}