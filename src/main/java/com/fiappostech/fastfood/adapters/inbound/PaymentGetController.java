package com.fiappostech.fastfood.adapters.inbound;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapters.inbound.dto.response.PaymentFullResponse;
import com.fiappostech.fastfood.application.ports.inbound.PaymentFindByOrderIdInputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentGetController {

   private final PaymentFindByOrderIdInputPort paymentFindByOrderIdInputPort;

   @GetMapping
   public ResponseEntity<PaymentFullResponse> paymentFindByPOrderId(@RequestParam UUID orderId) {
      var paymentResponse = paymentFindByOrderIdInputPort.execute(orderId);
      return ResponseEntity.ok(new PaymentFullResponse(paymentResponse));
   }
}