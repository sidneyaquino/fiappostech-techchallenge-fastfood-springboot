package com.fiappostech.fastfood.infrastructure.persistence.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.application.port.order.OrderFindByTrackingGateway;
import com.fiappostech.fastfood.domain.entity.OrderTracking;
import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;
import com.fiappostech.fastfood.infrastructure.persistence.order.entity.OrderEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OrderFindByTrackingRepository implements OrderFindByTrackingGateway {

   @Autowired
   private final OrderRepository orderRepository;

   @Transactional(readOnly = true)
   @Override
   public List<OrderResponse> execute(OrderTracking tracking) {
      List<OrderEntity> listOrderEntity = orderRepository.findAllByTracking(tracking);
      return listOrderEntity.stream().map(orderEntity -> orderEntity.toOrderResponse()).toList();
   }
}