package com.fiappostech.fastfood.infrastructure.api.payment;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapter.presenter.payment.PaymentFindByOrderIdPresenter;
import com.fiappostech.fastfood.adapter.presenter.payment.response.PaymentResponseFull;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Tag(name = "Payments") //, description = "the Payment Api")
@RestController
@RequestMapping("/payments")
public class PaymentGetController {

   private final PaymentFindByOrderIdPresenter paymentFindByOrderIdPresenter;

   @GetMapping
   public ResponseEntity<PaymentResponseFull> paymentFindByPOrderId(@RequestParam UUID orderId) {
      return ResponseEntity.ok(paymentFindByOrderIdPresenter.execute(orderId));
   }
}