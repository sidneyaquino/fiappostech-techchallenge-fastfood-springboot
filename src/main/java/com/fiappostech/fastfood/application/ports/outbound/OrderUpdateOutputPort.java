package com.fiappostech.fastfood.application.ports.outbound;

import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;

public interface OrderUpdateOutputPort {
   OrderResponse execute(OrderRequest orderRequest);
}