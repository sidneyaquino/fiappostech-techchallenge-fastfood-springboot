package com.fiappostech.fastfood.application.port.order;

import java.util.List;

import com.fiappostech.fastfood.domain.entity.OrderTracking;
import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;

public interface OrderFindByTrackingGateway {
   public List<OrderResponse> execute(OrderTracking tracking);
}