package com.fiappostech.fastfood.adapters.inbound;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiappostech.fastfood.adapters.inbound.dto.request.OrderPostRequest;
import com.fiappostech.fastfood.adapters.inbound.dto.response.OrderFullResponse;
import com.fiappostech.fastfood.application.ports.inbound.OrderInsertInputPort;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderPostControllerAdapter {

   private final OrderInsertInputPort orderInsertInputPort;

   @PostMapping
   public ResponseEntity<OrderFullResponse> orderSave(
         @RequestBody @Valid OrderPostRequest orderPostRequest,
         UriComponentsBuilder uriComponentsBuilder) {

      var orderRequest = orderPostRequest.toOrderRequest();
      var orderResponse = orderInsertInputPort.execute(orderRequest);
      // var uri = uriComponentsBuilder.path("/orders/{orderId}").buildAndExpand(orderResponse.orderId()).toUri();

      return ResponseEntity.ok().body(new OrderFullResponse(orderResponse));
      // return ResponseEntity.created(uri).body(new OrderFullResponse(orderResponse));
   }
}