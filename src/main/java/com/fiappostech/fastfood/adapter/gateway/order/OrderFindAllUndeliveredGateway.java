package com.fiappostech.fastfood.adapter.gateway.order;

import java.util.List;

import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.domain.entity.OrderTracking;

public interface OrderFindAllUndeliveredGateway {
   public List<OrderResponse> execute(List<OrderTracking> listTrackings);
}