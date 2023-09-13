package com.fiappostech.fastfood.infrastructure.api.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiappostech.fastfood.adapter.presenter.order.OrderCheckoutPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.request.OrderCheckoutPutRequest;
import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Tag(name = "Orders") //, description = "the Order Api")
@RestController
@RequestMapping("/orders/checkout")
public class OrderCheckoutPutController {

   @Autowired
   private final OrderCheckoutPresenter orderCheckoutPresenter;

   @PutMapping
   public ResponseEntity<OrderResponseTracking> orderCheckoutSave(
         @RequestBody @Valid OrderCheckoutPutRequest orderCheckoutPutRequest,
         UriComponentsBuilder uriComponentsBuilder) {

      var OrderResponseTracking = orderCheckoutPresenter.execute(orderCheckoutPutRequest);
      var uri = uriComponentsBuilder.path("/orders/{orderId}").buildAndExpand(OrderResponseTracking.orderId()).toUri();

      return ResponseEntity.created(uri).body(OrderResponseTracking);
   }
}