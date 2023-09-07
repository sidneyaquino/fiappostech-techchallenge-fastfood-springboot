package com.fiappostech.fastfood.infrastructure.api.order;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapter.presenter.order.OrderFindAllUndeliveredPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderFindByIdPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseFull;
import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;
import com.fiappostech.fastfood.domain.entity.OrderTracking;
import com.fiappostech.fastfood.domain.port.order.OrderFindByTrackingUseCase;
import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderGetController {

   private final OrderFindByIdPresenter orderFindByIdPresenter;
   private final OrderFindByTrackingUseCase orderFindByTrackingUseCase;
   private final OrderFindAllUndeliveredPresenter orderFindAllUndeliveredPresenter;

   @GetMapping("/{orderId}")
   public ResponseEntity<OrderResponseFull> orderFindById(@PathVariable UUID orderId) {
      return ResponseEntity.ok(orderFindByIdPresenter.execute(orderId));
   }

   @GetMapping
   public ResponseEntity<List<OrderResponseTracking>> orderFindByTracking(@RequestParam OrderTracking tracking) {

      List<OrderResponse> listOrderResponse = orderFindByTrackingUseCase.execute(tracking);
      var listOrderResponseTracking = listOrderResponse
            .stream().map(item -> new OrderResponseTracking(item)).toList();

      return ResponseEntity.ok(listOrderResponseTracking);
   }

   @GetMapping("/undelivered")
   public ResponseEntity<List<OrderResponseTracking>> orderFindAllUndelivered() {
      return ResponseEntity.ok(orderFindAllUndeliveredPresenter.execute());
   }
}