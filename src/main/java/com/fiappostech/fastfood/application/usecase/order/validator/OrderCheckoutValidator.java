package com.fiappostech.fastfood.application.usecase.order.validator;

import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;

public interface OrderCheckoutValidator{
   public void validate(OrderRequest orderRequest, OrderResponse orderResponse);
}
