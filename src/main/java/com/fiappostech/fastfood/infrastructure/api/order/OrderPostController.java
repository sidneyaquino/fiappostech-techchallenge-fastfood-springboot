package com.fiappostech.fastfood.infrastructure.api.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fiappostech.fastfood.adapter.presenter.order.OrderInsertPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.request.OrderPostRequest;
import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseFull;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Tag(name = "Orders") //, description = "the Order Api")
@RestController
@RequestMapping("/orders")
public class OrderPostController {

   private final OrderInsertPresenter orderInsertPresenter;

   @PostMapping
   public ResponseEntity<OrderResponseFull> orderSave(   
         @RequestBody @Valid OrderPostRequest orderPostRequest,
         UriComponentsBuilder uriComponentsBuilder) {

      var orderResponseFull = orderInsertPresenter.execute(orderPostRequest);
      var uri = uriComponentsBuilder.path("/orders/{orderId}").buildAndExpand(orderResponseFull.orderId()).toUri();

      return ResponseEntity.created(uri).body(orderResponseFull);
   }
}