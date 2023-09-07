package com.fiappostech.fastfood.application.usecase.product;

import com.fiappostech.fastfood.application.port.product.ProductSaveGateway;
import com.fiappostech.fastfood.domain.entity.ProductDomain;
import com.fiappostech.fastfood.domain.port.product.ProductSaveUseCase;
import com.fiappostech.fastfood.domain.port.product.dto.ProductRequest;
import com.fiappostech.fastfood.domain.port.product.dto.ProductResponse;

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