package com.fiappostech.fastfood.application.core;

import com.fiappostech.fastfood.application.core.domain.ProductDomain;
import com.fiappostech.fastfood.application.ports.dto.request.ProductRequest;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;
import com.fiappostech.fastfood.application.ports.inbound.ProductAddInputPort;
import com.fiappostech.fastfood.application.ports.outbound.ProductAddOutputPort;

public class ProductAddUseCase implements ProductAddInputPort{
   
   private final ProductAddOutputPort productAddOutputPort;

   public ProductAddUseCase(ProductAddOutputPort productAddOutputPort) {
      this.productAddOutputPort = productAddOutputPort;
   }

   @Override
   public ProductResponse execute(ProductRequest productRequest) {
      var productDomain = new ProductDomain(productRequest);

      //
      // Business Rules before Request.
      //      
      var productResponse = this.productAddOutputPort.execute(productDomain.toProductRequest());
      productDomain = new ProductDomain(productResponse);
      //
      // Business Rules before Response.
      //       

      return productDomain.toProductResponse();
   }

   
}
