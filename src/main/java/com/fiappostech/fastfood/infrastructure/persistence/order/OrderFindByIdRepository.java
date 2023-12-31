package com.fiappostech.fastfood.infrastructure.persistence.order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.domain.dto.order.OrderProductResponse;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.infrastructure.persistence.order.projection.OrderProductProjection;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OrderFindByIdRepository {

   @Autowired
   private final OrderRepository orderRepository;

   @Transactional(readOnly = true)
   public OrderResponse execute(UUID orderId) {
      List<OrderProductProjection> listOrderProductProjection = orderRepository.findAllOrderProductById(orderId);
      List<OrderProductResponse> listOrderProductResponse = new ArrayList<>();
      for (OrderProductProjection item : listOrderProductProjection) {
         listOrderProductResponse.add(this.toOrderProductResponse(item));
      }
      return orderRepository.getReferenceById(orderId).toOrderResponse(listOrderProductResponse);
   }

   private OrderProductResponse toOrderProductResponse(OrderProductProjection orderProductProjection) {
      return new OrderProductResponse(
            orderProductProjection.getProductId(),
            orderProductProjection.getDescription(), 
            orderProductProjection.getQuantity(),
            orderProductProjection.getValue());
   }   
}