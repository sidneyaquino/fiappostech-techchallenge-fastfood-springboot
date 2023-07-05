package com.fiappostech.fastfood.adapters.outbound;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.adapters.outbound.entity.ProductEntity;
import com.fiappostech.fastfood.adapters.outbound.repository.ProductRepository;
import com.fiappostech.fastfood.application.ports.dto.request.ProductRequest;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;
import com.fiappostech.fastfood.application.ports.outbound.ProductSaveOutputPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductSaveServiceAdapter implements ProductSaveOutputPort {

   @Autowired
   private final ProductRepository productRepository;

   @Transactional
   @Override
   public ProductResponse execute(ProductRequest productRequest) {

      try {
         ProductEntity productEntity;

         if (productRequest.productId() == null) {
            productEntity = new ProductEntity(productRequest);
         } else {
            productEntity = productRepository.findById(productRequest.productId()).get();
            BeanUtils.copyProperties(productRequest, productEntity);
         }
         return productRepository.save(productEntity).toProductResponse();

      } catch (Exception e) {
         throw e;
      }
   }
}