package com.fiappostech.fastfood.application.ports.inbound;

import com.fiappostech.fastfood.application.ports.dto.request.OrderCheckoutRequest;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;

public interface OrderCheckoutInputPort {
   OrderResponse execute(OrderCheckoutRequest orderCheckoutRequest);
}