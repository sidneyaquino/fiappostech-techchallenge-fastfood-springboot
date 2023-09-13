package com.fiappostech.fastfood.application.usecase.product;

import java.util.List;

import com.fiappostech.fastfood.adapter.gateway.product.ProductFindByCategoryGateway;
import com.fiappostech.fastfood.domain.dto.product.ProductResponse;
import com.fiappostech.fastfood.domain.entity.ProductCategory;
import com.fiappostech.fastfood.domain.entity.ProductDomain;

public class ProductFindByCategoryInteractor implements ProductFindByCategoryUseCase {
   
   private final ProductFindByCategoryGateway productFindByCategoryGateway;

   public ProductFindByCategoryInteractor(ProductFindByCategoryGateway productFindByCategoryGateway) {
      this.productFindByCategoryGateway = productFindByCategoryGateway;
   }

   @Override
   public List<ProductResponse> execute(ProductCategory category) {
      
      //
      // Business Rules before Request.
      //

      //
      // Request.
      //      
      var listProductResponse = this.productFindByCategoryGateway.execute(category);
      var listProductDomain = listProductResponse.stream().map(ProductDomain::new).toList();

      //
      // Business Rules before Response.
      //

      return listProductDomain.stream().map(item -> item.toProductResponse()).toList();
   }
}