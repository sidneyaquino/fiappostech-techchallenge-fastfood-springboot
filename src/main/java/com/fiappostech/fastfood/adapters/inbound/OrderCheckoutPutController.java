package com.fiappostech.fastfood.adapters.inbound;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapters.inbound.dto.request.OrderCheckoutPutRequest;
import com.fiappostech.fastfood.adapters.inbound.dto.response.OrderFullResponse;
import com.fiappostech.fastfood.application.ports.inbound.OrderCheckoutInputPort;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/orders/checkout")
public class OrderCheckoutPutController {

   private final OrderCheckoutInputPort orderCheckoutInputPort;

   @PutMapping
   public ResponseEntity<OrderFullResponse> orderSave(
         @RequestBody @Valid OrderCheckoutPutRequest orderCheckoutPutRequest) {

      var orderResponse = orderCheckoutInputPort.execute(orderCheckoutPutRequest.toOrderCheckoutRequest());
      return ResponseEntity.ok(new OrderFullResponse(orderResponse));
   }
}