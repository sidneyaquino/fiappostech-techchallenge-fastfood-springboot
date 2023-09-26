package com.fiappostech.fastfood.infrastructure.api.order;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapter.presenter.order.OrderFindAllUndeliveredPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderFindByIdPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.OrderFindByTrackingPresenter;
import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseFull;
import com.fiappostech.fastfood.adapter.presenter.order.response.OrderResponseTracking;
import com.fiappostech.fastfood.domain.entity.OrderTracking;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Orders") // , description = "the Order Api")
@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderGetController {

   @Autowired
   private final OrderFindByIdPresenter orderFindByIdPresenter;
   @Autowired
   private final OrderFindByTrackingPresenter orderFindByTrackingPresenter;
   @Autowired
   private final OrderFindAllUndeliveredPresenter orderFindAllUndeliveredPresenter;

   @GetMapping("/{orderId}")
   public ResponseEntity<OrderResponseFull> orderFindById(@PathVariable UUID orderId) {
      return ResponseEntity.ok(orderFindByIdPresenter.execute(orderId));
   }

   @GetMapping
   public ResponseEntity<List<OrderResponseTracking>> orderFindByTracking(@RequestParam OrderTracking tracking) {
      return ResponseEntity.ok(orderFindByTrackingPresenter.execute(tracking));
   }

   @GetMapping("/undelivered")
   public ResponseEntity<List<OrderResponseTracking>> orderFindAllUndelivered() {
      return ResponseEntity.ok(orderFindAllUndeliveredPresenter.execute());
   }
}