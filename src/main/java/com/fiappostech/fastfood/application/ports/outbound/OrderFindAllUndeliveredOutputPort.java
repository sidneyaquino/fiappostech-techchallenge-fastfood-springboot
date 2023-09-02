package com.fiappostech.fastfood.application.ports.outbound;

import java.util.List;

import com.fiappostech.fastfood.application.ports.dto.OrderTracking;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;

public interface OrderFindAllUndeliveredOutputPort {
   public List<OrderResponse> execute(List<OrderTracking> listTrackings);
}