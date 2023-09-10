package com.fiappostech.fastfood.infrastructure.api.payment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiappostech.fastfood.adapter.presenter.payment.PaymentInsertPresenter;
import com.fiappostech.fastfood.adapter.presenter.payment.request.PaymentPostRequest;
import com.fiappostech.fastfood.adapter.presenter.payment.response.PaymentResponseFull;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Tag(name = "Payments") //, description = "the Payment Api")
@RestController
@RequestMapping("/payments")
public class PaymentPostController {

   private final PaymentInsertPresenter paymentInsertPresenter;

   @PostMapping
   public ResponseEntity<PaymentResponseFull> paymentSave(   
         @RequestBody @Valid PaymentPostRequest paymentPostRequest,
         UriComponentsBuilder uriComponentsBuilder) {

      var paymentResponseFull = paymentInsertPresenter.execute(paymentPostRequest);
      var uri = uriComponentsBuilder.path("/payments/{paymentId}").buildAndExpand(paymentResponseFull.paymentId()).toUri();

      return ResponseEntity.created(uri).body(paymentResponseFull);
   }
}