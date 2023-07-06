package com.fiappostech.fastfood.adapters.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.entity.ProductEntity;
import com.fiappostech.fastfood.adapters.outbound.repository.ProductRepository;
import com.fiappostech.fastfood.application.ports.dto.request.ProductRequest;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;
import com.fiappostech.fastfood.application.ports.outbound.ProductSaveOutputPort;
import com.fiappostech.fastfood.infrastructure.exception.RecordNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductSaveServiceAdapter implements ProductSaveOutputPort {

   @Autowired
   private final ProductRepository productRepository;

   @Transactional
   @Override
   public ProductResponse execute(ProductRequest productRequest) {
      ProductEntity productEntity;

      if (productRequest.productId() == null) {
         productEntity = new ProductEntity(productRequest);
         productRepository.save(productEntity);
      } else {
         
         var productOptional = productRepository.findById(productRequest.productId());
         if(productOptional.isEmpty()) {
            throw new RecordNotFoundException(productRequest.productId());
         }
         productEntity = productOptional.get();
         productEntity.update(productRequest);
      }
      return productEntity.toProductResponse();
   }
}