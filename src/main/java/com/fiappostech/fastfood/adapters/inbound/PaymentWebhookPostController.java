package com.fiappostech.fastfood.adapters.inbound;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiappostech.fastfood.adapters.inbound.dto.request.PaymentPostRequest;
import com.fiappostech.fastfood.adapters.inbound.dto.response.PaymentFullResponse;
import com.fiappostech.fastfood.application.ports.inbound.PaymentInsertInputPort;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentWebhookPostController {

   private final PaymentInsertInputPort paymentInsertInputPort;

   @PostMapping
   public ResponseEntity<PaymentFullResponse> paymentSave(   
         @RequestBody @Valid PaymentPostRequest paymentPostRequest,
         UriComponentsBuilder uriComponentsBuilder) {

      var paymentRequest = paymentPostRequest.toPaymentRequest();
      var paymentResponse = paymentInsertInputPort.execute(paymentRequest);
      var uri = uriComponentsBuilder.path("/payments/{paymentId}").buildAndExpand(paymentResponse.paymentId()).toUri();

      return ResponseEntity.created(uri).body(new PaymentFullResponse(paymentResponse));
   }
}