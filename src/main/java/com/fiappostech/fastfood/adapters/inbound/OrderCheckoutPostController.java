package com.fiappostech.fastfood.adapters.inbound;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiappostech.fastfood.adapters.inbound.dto.request.OrderCheckoutPostRequest;
import com.fiappostech.fastfood.adapters.inbound.dto.response.OrderTrackingResponse;
import com.fiappostech.fastfood.application.ports.inbound.OrderCheckoutInputPort;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/ordercheckout")
public class OrderCheckoutPostController {

   private final OrderCheckoutInputPort orderCheckoutInputPort;

   @PostMapping
   public ResponseEntity<OrderTrackingResponse> orderCheckoutSave(
         @RequestBody @Valid OrderCheckoutPostRequest orderCheckoutPostRequest,
         UriComponentsBuilder uriComponentsBuilder) {

      var orderCheckoutRequest = orderCheckoutPostRequest.toOrderCheckoutRequest();
      var orderResponse = orderCheckoutInputPort.execute(orderCheckoutRequest);
      var uri = uriComponentsBuilder.path("/orders/{orderId}").buildAndExpand(orderResponse.orderId()).toUri();            

      return ResponseEntity.created(uri).body(new OrderTrackingResponse(orderResponse));
   }
}