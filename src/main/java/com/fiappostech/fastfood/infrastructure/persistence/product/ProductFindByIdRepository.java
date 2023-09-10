package com.fiappostech.fastfood.infrastructure.persistence.product;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.domain.dto.product.ProductResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductFindByIdRepository {

   @Autowired
   private final ProductRepository productRepository;

   @Transactional(readOnly = true)
   public ProductResponse execute(UUID productId) {
      return productRepository.getReferenceById(productId).toProductResponse();
   }
}