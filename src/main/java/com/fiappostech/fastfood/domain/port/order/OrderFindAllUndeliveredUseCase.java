package com.fiappostech.fastfood.domain.port.order;

import java.util.List;

import com.fiappostech.fastfood.domain.port.order.dto.OrderResponse;

public interface OrderFindAllUndeliveredUseCase {
   List<OrderResponse> execute();
}