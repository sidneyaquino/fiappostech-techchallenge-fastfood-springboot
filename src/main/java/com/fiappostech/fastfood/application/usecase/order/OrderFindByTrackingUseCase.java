package com.fiappostech.fastfood.application.usecase.order;

import java.util.List;

import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.domain.entity.OrderTracking;

public interface OrderFindByTrackingUseCase {
   List<OrderResponse> execute(OrderTracking tracking);
}