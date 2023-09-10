package com.fiappostech.fastfood.application.usecase.order;

import java.util.List;

import com.fiappostech.fastfood.domain.dto.order.OrderResponse;

public interface OrderFindAllUndeliveredUseCase {
   List<OrderResponse> execute();
}