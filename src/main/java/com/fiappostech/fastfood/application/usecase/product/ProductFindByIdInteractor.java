package com.fiappostech.fastfood.application.usecase.product;

import java.util.UUID;

import com.fiappostech.fastfood.application.port.product.ProductFindByIdGateway;
import com.fiappostech.fastfood.domain.entity.ProductDomain;
import com.fiappostech.fastfood.domain.port.product.ProductFindByIdUseCase;
import com.fiappostech.fastfood.domain.port.product.dto.ProductResponse;

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
      var productResponse = this.productFindByIdGateway.execute(productId);
      var productDomain = new ProductDomain(productResponse); 
      //
      // Business Rules before Response.
      //

      return productDomain.toProductResponse();
   }
}