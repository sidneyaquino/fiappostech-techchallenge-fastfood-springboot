package com.fiappostech.fastfood.adapters.outbound;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.repository.OrderRepository;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.outbound.OrderFindByIdOutputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OrderFindByIdServiceAdapter implements OrderFindByIdOutputPort {

   @Autowired
   private final OrderRepository orderRepository;

   @Transactional(readOnly = true)
   @Override
   public OrderResponse execute(UUID orderId) {
      return orderRepository.getReferenceById(orderId).toOrderResponse();
   }
}