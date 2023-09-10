package com.fiappostech.fastfood.infrastructure.persistence.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.domain.dto.order.OrderProductResponse;
import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.dto.order.OrderResponse;
import com.fiappostech.fastfood.infrastructure.exception.RecordNotFoundException;
import com.fiappostech.fastfood.infrastructure.persistence.order.entity.OrderEntity;
import com.fiappostech.fastfood.infrastructure.persistence.order.entity.OrderProductEntity;
import com.fiappostech.fastfood.infrastructure.persistence.product.ProductRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OrderInsertRepository {

   @Autowired
   private final OrderRepository orderRepository;

   @Autowired
   private final ProductRepository productRepository;

   @Autowired
   private final OrderProductRepository orderProductRepository;

   @Transactional
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