package com.fiappostech.fastfood.infrastructure.persistence.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.domain.entity.OrderTracking;
import com.fiappostech.fastfood.infrastructure.persistence.order.entity.OrderEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OrderFindByTrackingRepository {

   @Autowired
   private final OrderRepository orderRepository;

   @Transactional(readOnly = true)
   public List<OrderResponse> execute(OrderTracking tracking) {
      List<OrderEntity> listOrderEntity = orderRepository.findAllByTracking(tracking);
      return listOrderEntity.stream().map(orderEntity -> orderEntity.toOrderResponse()).toList();
   }
}