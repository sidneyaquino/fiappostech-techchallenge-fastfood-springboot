package com.fiappostech.fastfood.infrastructure.persistence.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapter.gateway.order.OrderUpdateGateway;
import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.infrastructure.exception.RecordNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OrderUpdateRepository implements OrderUpdateGateway {

   @Autowired
   private final OrderRepository orderRepository;

   @Transactional
   @Override
   public OrderResponse execute(OrderRequest orderRequest) {
      // List<OrderProductEntity> listOrderProductEntity = new ArrayList<>();

      var orderOptional = orderRepository.findById(orderRequest.orderId());
      if (orderOptional.isEmpty()) {
         throw new RecordNotFoundException(orderRequest.orderId());
      }
      var orderEntity = orderOptional.get();
      orderEntity.update(orderRequest);
      
      return orderEntity.toOrderResponse();
   }
}