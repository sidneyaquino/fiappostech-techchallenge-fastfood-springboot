package com.fiappostech.fastfood.adapter.gateway.order;

import java.util.List;

import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.domain.entity.OrderTracking;

public interface OrderFindByTrackingGateway {
   public List<OrderResponse> execute(OrderTracking tracking);
}