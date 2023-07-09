package com.fiappostech.fastfood.application.ports.outbound;

import java.util.List;

import com.fiappostech.fastfood.application.ports.dto.Tracking;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;

public interface OrderFindByTrackingOutputPort {
   public List<OrderResponse> execute(Tracking tracking);
}