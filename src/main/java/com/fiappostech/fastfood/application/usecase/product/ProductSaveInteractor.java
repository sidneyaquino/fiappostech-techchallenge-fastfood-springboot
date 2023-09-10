package com.fiappostech.fastfood.application.usecase.product;

import com.fiappostech.fastfood.adapter.gateway.product.ProductSaveGateway;
import com.fiappostech.fastfood.domain.dto.product.ProductRequest;
import com.fiappostech.fastfood.domain.dto.product.ProductResponse;
import com.fiappostech.fastfood.domain.entity.ProductDomain;

public class ProductSaveInteractor implements ProductSaveUseCase{
   
   private final ProductSaveGateway productSaveGateway;

   public ProductSaveInteractor(ProductSaveGateway productSaveGateway) {
      this.productSaveGateway = productSaveGateway;
   }

   @Override
   public ProductResponse execute(ProductRequest productRequest) {
      var productDomain = new ProductDomain(productRequest);

      //
      // Business Rules before Request.
      //      
      var productResponse = this.productSaveGateway.execute(productDomain.toProductRequest());
      productDomain = new ProductDomain(productResponse);
      //
      // Business Rules before Response.
      //       

      return productDomain.toProductResponse();
   }  
}