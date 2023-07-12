package com.fiappostech.fastfood.adapters.inbound;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiappostech.fastfood.adapters.inbound.dto.response.OrderFullResponse;
import com.fiappostech.fastfood.adapters.inbound.dto.response.OrderTrackingResponse;
import com.fiappostech.fastfood.application.ports.dto.Tracking;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.inbound.OrderFindByIdInputPort;
import com.fiappostech.fastfood.application.ports.inbound.OrderFindByTrackingInputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderGetController {

   private final OrderFindByIdInputPort orderFindByIdInputPort;
   private final OrderFindByTrackingInputPort orderFindByTrackingInputPort;

   @GetMapping("/{orderId}")
   public ResponseEntity<OrderFullResponse> orderFindById(@PathVariable UUID orderId) {
      var orderResponse = orderFindByIdInputPort.execute(orderId);
      return ResponseEntity.ok(new OrderFullResponse(orderResponse));
   }

   @GetMapping
   public ResponseEntity<List<OrderTrackingResponse>> orderFindByTracking(@RequestParam Tracking tracking) {

      List<OrderResponse> listOrderResponse = orderFindByTrackingInputPort.execute(tracking);
      var listOrderTrackingResponse = listOrderResponse
            .stream().map(item -> new OrderTrackingResponse(item)).toList();

      return ResponseEntity.ok(listOrderTrackingResponse);
   }
}