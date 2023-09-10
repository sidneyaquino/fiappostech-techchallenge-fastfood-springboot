package com.fiappostech.fastfood.adapter.gateway.order;

import java.util.List;

import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.domain.entity.OrderTracking;
import com.fiappostech.fastfood.infrastructure.persistence.order.OrderFindByTrackingRepository;

public class OrderFindByTrackingRepositoryGateway implements OrderFindByTrackingGateway {

   private final OrderFindByTrackingRepository orderFindByTrackingRepository;

   public OrderFindByTrackingRepositoryGateway(OrderFindByTrackingRepository OrderFindByTrackingRepository) {
      this.orderFindByTrackingRepository = OrderFindByTrackingRepository;
   }

   @Override
   public List<OrderResponse> execute(OrderTracking tracking) {
      return orderFindByTrackingRepository.execute(tracking);
   }
}