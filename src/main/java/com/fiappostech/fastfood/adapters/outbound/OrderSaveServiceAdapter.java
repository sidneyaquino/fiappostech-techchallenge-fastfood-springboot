package com.fiappostech.fastfood.adapters.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.entity.OrderEntity;
import com.fiappostech.fastfood.adapters.outbound.repository.OrderRepository;
import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.outbound.OrderSaveOutputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OrderSaveServiceAdapter implements OrderSaveOutputPort {

   @Autowired
   private final OrderRepository orderRepository;

   @Transactional
   @Override
   public OrderResponse execute(OrderRequest orderRequest) {
      OrderEntity orderEntity = new OrderEntity(orderRequest);
      orderEntity = orderRepository.save(orderEntity);
      return orderEntity.toOrderResponse();
   }
}