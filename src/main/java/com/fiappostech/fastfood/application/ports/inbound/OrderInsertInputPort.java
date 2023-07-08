package com.fiappostech.fastfood.application.ports.inbound;

import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;

public interface OrderInsertInputPort {
   OrderResponse execute(OrderRequest orderRequest);
}