package com.fiappostech.fastfood.infrastructure.api.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapter.presenter.order.OrderUpdatePresenter;
import com.fiappostech.fastfood.adapter.presenter.order.request.OrderPutRequest;
import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(name = "Orders") //, description = "the Order Api")
@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderPutController {

   @Autowired
   private final OrderUpdatePresenter orderUpdatePresenter;

   @PutMapping
   public ResponseEntity<OrderResponseTracking> orderSave(
         @RequestBody @Valid OrderPutRequest orderPutRequest) {

      return ResponseEntity.ok(orderUpdatePresenter.execute(orderPutRequest));
   }
}