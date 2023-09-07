package com.fiappostech.fastfood.application.usecase.product;

import java.util.List;

import com.fiappostech.fastfood.application.port.product.ProductFindByCategoryGateway;
import com.fiappostech.fastfood.domain.entity.ProductCategory;
import com.fiappostech.fastfood.domain.entity.ProductDomain;
import com.fiappostech.fastfood.domain.port.product.ProductFindByCategoryUseCase;
import com.fiappostech.fastfood.domain.port.product.dto.ProductResponse;

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
      var listProductResponse = this.productFindByCategoryGateway.execute(category);
      var listProductDomain = listProductResponse.stream().map(ProductDomain::new).toList();
      //
      // Business Rules before Response.
      //

      return listProductDomain.stream().map(item -> item.toProductResponse()).toList();
   }
}