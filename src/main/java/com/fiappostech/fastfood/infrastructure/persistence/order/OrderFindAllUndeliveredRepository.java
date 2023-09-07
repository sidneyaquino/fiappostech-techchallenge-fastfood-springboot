package com.fiappostech.fastfood.infrastructure.persistence.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.application.port.order.OrderFindAllUndeliveredGateway;
import com.fiappostech.fastfood.domain.entity.OrderTracking;
import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;
import com.fiappostech.fastfood.infrastructure.persistence.order.entity.OrderEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OrderFindAllUndeliveredRepository implements OrderFindAllUndeliveredGateway {
             
   @Autowired
   private final OrderRepository orderRepository;

   @Transactional(readOnly = true)
   @Override
   public List<OrderResponse> execute(List<OrderTracking> listTracking) {
      List<OrderEntity> listOrderEntity = orderRepository.findAllByTrackingInOrderByTrackingDesc(listTracking);
      return listOrderEntity.stream().map(orderEntity -> orderEntity.toOrderResponse()).toList();
   }
}