package com.fiappostech.fastfood.application.core;

import com.fiappostech.fastfood.application.core.domain.ProductDomain;
import com.fiappostech.fastfood.application.ports.dto.request.ProductRequest;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;
import com.fiappostech.fastfood.application.ports.inbound.ProductUpdateInputPort;
import com.fiappostech.fastfood.application.ports.outbound.ProductSaveOutputPort;

public class ProductUpdateUseCase implements ProductUpdateInputPort {

   private final ProductSaveOutputPort productSaveOutputPort;

   public ProductUpdateUseCase(ProductSaveOutputPort productSaveOutputPort) {
      this.productSaveOutputPort = productSaveOutputPort;
   }

   @Override
   public ProductResponse execute(ProductRequest productRequest) {
      var productDomain = new ProductDomain(productRequest);

      //
      // Business Rules before Request.
      //
      var productResponse = this.productSaveOutputPort.execute(productDomain.toProductRequest());
      productDomain = new ProductDomain(productResponse);
      //
      // Business Rules before Response.
      //

      return productDomain.toProductResponse();
   }
}