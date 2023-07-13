package com.fiappostech.fastfood.adapters.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.entity.OrderEntity;
import com.fiappostech.fastfood.adapters.outbound.repository.OrderRepository;
import com.fiappostech.fastfood.application.ports.dto.request.OrderRequest;
import com.fiappostech.fastfood.application.ports.dto.response.OrderResponse;
import com.fiappostech.fastfood.application.ports.outbound.OrderUpdateOutputPort;
import com.fiappostech.fastfood.config.exception.RecordNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OrderUpdateRepository implements OrderUpdateOutputPort {

   @Autowired
   private final OrderRepository orderRepository;

   // @Autowired
   // private final ProductRepository productRepository;

   // @Autowired
   // private final OrderProductRepository orderProductRepository;

   @Transactional
   @Override
   public OrderResponse execute(OrderRequest orderRequest) {
      // List<OrderProductEntity> listOrderProductEntity = new ArrayList<>();
      OrderEntity orderEntity;

      // if (orderRequest.orderId() == null) {
      //    orderEntity = new OrderEntity(orderRequest);
      //    orderRepository.save(orderEntity);

      //    for (var item : orderRequest.products()) {
      //       var orderOptional = productRepository.findById(item.productId());
      //       if (orderOptional.isEmpty()) {
      //          throw new RecordNotFoundException(item.productId());
      //       }
      //       var productEntity = orderOptional.get();

      //       listOrderProductEntity.add(new OrderProductEntity(item, orderEntity, productEntity));
      //    }
      //    orderProductRepository.saveAll(listOrderProductEntity);
      // } else {

         var orderOptional = orderRepository.findById(orderRequest.orderId());
         if (orderOptional.isEmpty()) {
            throw new RecordNotFoundException(orderRequest.orderId());
         }
         orderEntity = orderOptional.get();
         orderEntity.update(orderRequest);
      // }
      return orderEntity.toOrderResponse();
   }
}