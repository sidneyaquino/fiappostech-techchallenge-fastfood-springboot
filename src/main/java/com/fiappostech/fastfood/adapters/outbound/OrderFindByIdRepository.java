package com.fiappostech.fastfood.adapters.outbound;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.projection.OrderProductProjection;
import com.fiappostech.fastfood.adapters.outbound.repository.OrderRepository;
import com.fiappostech.fastfood.application.ports.dto.response.OrderProductResponse;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.outbound.OrderFindByIdOutputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OrderFindByIdRepository implements OrderFindByIdOutputPort {

   @Autowired
   private final OrderRepository orderRepository;

   @Transactional(readOnly = true)
   @Override
   public OrderResponse execute(UUID orderId) {
      List<OrderProductProjection> listOrderProductProjection = orderRepository.findAllOrderProductById(orderId);
      List<OrderProductResponse> listOrderProductResponse = new ArrayList<>();
      for (OrderProductProjection item : listOrderProductProjection) {
         listOrderProductResponse.add(new OrderProductResponse(item));
      }
      return orderRepository.getReferenceById(orderId).toOrderResponse(listOrderProductResponse);
   }
}