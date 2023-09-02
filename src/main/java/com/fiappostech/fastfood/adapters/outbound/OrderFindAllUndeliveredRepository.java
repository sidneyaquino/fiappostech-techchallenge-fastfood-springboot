package com.fiappostech.fastfood.adapters.outbound;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.entity.OrderEntity;
import com.fiappostech.fastfood.adapters.outbound.repository.OrderRepository;
import com.fiappostech.fastfood.application.ports.dto.OrderTracking;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.outbound.OrderFindAllUndeliveredOutputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OrderFindAllUndeliveredRepository implements OrderFindAllUndeliveredOutputPort {
             
   @Autowired
   private final OrderRepository orderRepository;

   @Transactional(readOnly = true)
   @Override
   public List<OrderResponse> execute(List<OrderTracking> listTracking) {
      List<OrderEntity> listOrderEntity = orderRepository.findAllByTrackingInOrderByTrackingDesc(listTracking);
      return listOrderEntity.stream().map(orderEntity -> orderEntity.toOrderResponse()).toList();
   }
}