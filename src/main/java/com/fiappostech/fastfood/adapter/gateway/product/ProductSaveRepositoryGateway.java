package com.fiappostech.fastfood.adapter.gateway.product;

import com.fiappostech.fastfood.domain.dto.product.ProductRequest;
import com.fiappostech.fastfood.domain.dto.product.ProductResponse;
import com.fiappostech.fastfood.infrastructure.persistence.product.ProductSaveRepository;

public class ProductSaveRepositoryGateway implements ProductSaveGateway {

   private final ProductSaveRepository productSaveRepository;

   public ProductSaveRepositoryGateway(ProductSaveRepository productSaveRepository) {
      this.productSaveRepository = productSaveRepository;
   }

   @Override
   public ProductResponse execute(ProductRequest productRequest) {
      return productSaveRepository.execute(productRequest);
   }
}