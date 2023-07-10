package com.fiappostech.fastfood.adapters.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.entity.OrderEntity;
import com.fiappostech.fastfood.adapters.outbound.repository.OrderRepository;
import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.outbound.OrderSaveOutputPort;
import com.fiappostech.fastfood.infrastructure.exception.RecordNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OrderSaveServiceAdapter implements OrderSaveOutputPort {

   @Autowired
   private final OrderRepository orderRepository;

   @Transactional
   @Override
   public OrderResponse execute(OrderRequest orderRequest) {
      OrderEntity orderEntity;
      if (orderRequest.orderId() == null) {
         orderEntity = new OrderEntity(orderRequest);
         orderRepository.save(orderEntity);   
      } else {

         var orderOptional = orderRepository.findById(orderRequest.orderId());
         if(orderOptional.isEmpty()) {
            throw new RecordNotFoundException(orderRequest.orderId());
         }
         orderEntity = orderOptional.get();
         orderEntity.update(orderRequest);
      }
      return orderEntity.toOrderResponse();
   }
}