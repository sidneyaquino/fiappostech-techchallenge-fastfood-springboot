package com.fiappostech.fastfood.adapter.gateway.product;

import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.product.ProductResponse;
import com.fiappostech.fastfood.infrastructure.persistence.product.ProductFindByIdRepository;

public class ProductFindByIdRepositoryGateway implements ProductFindByIdGateway {

   private final ProductFindByIdRepository productFindByIdRepository;

   public ProductFindByIdRepositoryGateway(ProductFindByIdRepository productFindByIdRepository) {
      this.productFindByIdRepository = productFindByIdRepository;
   }

   @Override
   public ProductResponse execute(UUID productId) {
      return productFindByIdRepository.execute(productId);
   }
}