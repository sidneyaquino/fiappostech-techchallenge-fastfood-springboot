package com.fiappostech.fastfood.infrastructure.persistence.product;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fiappostech.fastfood.application.port.product.ProductFindByIdGateway;
import com.fiappostech.fastfood.domain.port.product.dto.ProductResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductFindByIdRepository implements ProductFindByIdGateway {

   @Autowired
   private final ProductRepository productRepository;

   @Transactional(readOnly = true)
   @Override
   public ProductResponse execute(UUID productId) {
      return productRepository.getReferenceById(productId).toProductResponse();
   }
}