package com.fiappostech.fastfood.adapter.gateway.product;

import java.util.UUID;

import com.fiappostech.fastfood.infrastructure.persistence.product.ProductDeleteByIdRepository;

public class ProductDeleteByIdRepositoryGateway implements ProductDeleteByIdGateway {

   private final ProductDeleteByIdRepository productDeleteByIdRepository;

   public ProductDeleteByIdRepositoryGateway(ProductDeleteByIdRepository productDeleteByIdRepository) {
      this.productDeleteByIdRepository = productDeleteByIdRepository;
   }

   @Override
   public void execute(UUID productId) {
      productDeleteByIdRepository.execute(productId);
   }
}