package com.fiappostech.fastfood.application.ports.inbound;

import java.util.List;

import com.fiappostech.fastfood.application.ports.dto.Tracking;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;

public interface OrderFindByTrackingInputPort {
   List<OrderResponse> execute(Tracking tracking);
}