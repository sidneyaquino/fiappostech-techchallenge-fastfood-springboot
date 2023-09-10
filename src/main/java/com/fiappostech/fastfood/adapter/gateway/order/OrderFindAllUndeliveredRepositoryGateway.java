package com.fiappostech.fastfood.adapter.gateway.order;

import java.util.List;

import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.domain.entity.OrderTracking;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderFindAllUndeliveredRepository;

public class OrderFindAllUndeliveredRepositoryGateway implements OrderFindAllUndeliveredGateway {

   private final OrderFindAllUndeliveredRepository orderFindAllUndeliveredRepository;

   public OrderFindAllUndeliveredRepositoryGateway(OrderFindAllUndeliveredRepository orderFindAllUndeliveredRepository) {
      this.orderFindAllUndeliveredRepository = orderFindAllUndeliveredRepository;
   }

   @Override
   public List<OrderResponse> execute(List<OrderTracking> listTrackings) {
      return orderFindAllUndeliveredRepository.execute(listTrackings);
   }
}