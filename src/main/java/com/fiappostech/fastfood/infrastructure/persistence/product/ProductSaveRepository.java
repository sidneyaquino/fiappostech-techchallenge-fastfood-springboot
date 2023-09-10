package com.fiappostech.fastfood.infrastructure.persistence.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapter.gateway.product.ProductSaveGateway;
import com.fiappostech.fastfood.domain.dto.product.ProductRequest;
import com.fiappostech.fastfood.domain.dto.product.ProductResponse;
import com.fiappostech.fastfood.infrastructure.exception.RecordNotFoundException;
import com.fiappostech.fastfood.infrastructure.persistence.product.entity.ProductEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductSaveRepository implements ProductSaveGateway {

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