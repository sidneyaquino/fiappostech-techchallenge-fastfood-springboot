package com.fiappostech.fastfood.adapters.outbound;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.entity.OrderEntity;
import com.fiappostech.fastfood.adapters.outbound.entity.OrderProductEntity;
import com.fiappostech.fastfood.adapters.outbound.repository.OrderProductRepository;
import com.fiappostech.fastfood.adapters.outbound.repository.OrderRepository;
import com.fiappostech.fastfood.adapters.outbound.repository.ProductRepository;
import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;
import com.fiappostech.fastfood.application.ports.dto.response.OrderProductResponse;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.outbound.OrderInsertOutputPort;
import com.fiappostech.fastfood.config.exception.RecordNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OrderInsertRepository implements OrderInsertOutputPort {

   @Autowired
   private final OrderRepository orderRepository;

   @Autowired
   private final ProductRepository productRepository;

   @Autowired
   private final OrderProductRepository orderProductRepository;

   @Transactional
   @Override
   public OrderResponse execute(OrderRequest orderRequest) {
      OrderEntity orderEntity = new OrderEntity(orderRequest);
      orderRepository.save(orderEntity);

      List<OrderProductEntity> listOrderProductEntity = new ArrayList<>();      
      for (var item : orderRequest.products()) {

         var orderOptional = productRepository.findById(item.productId());
         if (orderOptional.isEmpty()) {
            throw new RecordNotFoundException(item.productId());
         }
         var productEntity = orderOptional.get();
         listOrderProductEntity.add(new OrderProductEntity(orderEntity, productEntity, item.quantity()));
      }
      orderProductRepository.saveAll(listOrderProductEntity);

      List<OrderProductResponse> listOrderProductResponse = new ArrayList<>();
      for (OrderProductEntity item : listOrderProductEntity) {
         listOrderProductResponse.add(item.toOrderProductResponse());
      }
      return orderEntity.toOrderResponse(listOrderProductResponse);
   }
}