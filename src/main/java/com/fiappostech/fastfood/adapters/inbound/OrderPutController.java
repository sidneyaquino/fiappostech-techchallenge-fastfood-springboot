package com.fiappostech.fastfood.adapters.inbound;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapters.inbound.dto.request.OrderPutRequest;
import com.fiappostech.fastfood.adapters.inbound.dto.response.OrderTrackingResponse;
import com.fiappostech.fastfood.application.ports.inbound.OrderUpdateInputPort;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderPutController {

   private final OrderUpdateInputPort orderUpdateInputPort;

   @PutMapping
   public ResponseEntity<OrderTrackingResponse> orderSave(
         @RequestBody @Valid OrderPutRequest orderPutRequest) {

      var orderResponse = orderUpdateInputPort.execute(orderPutRequest.toOrderRequest());
      return ResponseEntity.ok(new OrderTrackingResponse(orderResponse));
   }
}