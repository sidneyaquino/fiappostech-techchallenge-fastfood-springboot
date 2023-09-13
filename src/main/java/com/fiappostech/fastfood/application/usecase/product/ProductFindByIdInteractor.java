package com.fiappostech.fastfood.application.usecase.product;

import java.util.UUID;

import com.fiappostech.fastfood.adapter.gateway.product.ProductFindByIdGateway;
import com.fiappostech.fastfood.domain.dto.product.ProductResponse;
import com.fiappostech.fastfood.domain.entity.ProductDomain;

public class ProductFindByIdInteractor implements ProductFindByIdUseCase {
   
   private final ProductFindByIdGateway productFindByIdGateway;

   public ProductFindByIdInteractor(ProductFindByIdGateway productFindByIdGateway) {
      this.productFindByIdGateway = productFindByIdGateway;
   }

   @Override
   public ProductResponse execute(UUID productId) {
      
      //
      // Business Rules before Request.
      //

      //
      // Request.
      //
      var productResponse = this.productFindByIdGateway.execute(productId);
      var productDomain = new ProductDomain(productResponse); 

      //
      // Business Rules before Response.
      //

      return productDomain.toProductResponse();
   }
}