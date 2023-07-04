package com.fiappostech.fastfood.adapters.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.entity.ProductEntity;
import com.fiappostech.fastfood.adapters.outbound.repository.ProductRepository;
import com.fiappostech.fastfood.application.ports.dto.request.ProductRequest;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;
import com.fiappostech.fastfood.application.ports.outbound.ProductAddOutputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductInsertServiceAdapter implements ProductAddOutputPort {
 
   @Autowired
   private final ProductRepository productRepository;

   @Transactional
   @Override
   public ProductResponse execute(ProductRequest productRequest) {
      
      try {
         return productRepository.save(new ProductEntity(productRequest)).toProductResponse();
         
      } catch (Exception e) {
         throw e;
      }
   }
}