package com.fiappostech.fastfood.adapter.gateway.product;

import java.util.List;

import com.fiappostech.fastfood.domain.dto.product.ProductResponse;
import com.fiappostech.fastfood.domain.entity.ProductCategory;
import com.fiappostech.fastfood.infrastructure.persistence.product.ProductFindByCategoryRepository;

public class ProductFindByCategoryRepositoryGateway implements ProductFindByCategoryGateway {

   private final ProductFindByCategoryRepository productFindByCategoryRepository;

   public ProductFindByCategoryRepositoryGateway(ProductFindByCategoryRepository ProductFindByCategoryRepository) {
      this.productFindByCategoryRepository = ProductFindByCategoryRepository;
   }

   @Override
   public List<ProductResponse> execute(ProductCategory category) {
      return productFindByCategoryRepository.execute(category);
   }
}