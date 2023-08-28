package com.fiappostech.fastfood.application.core.usecases;

import com.fiappostech.fastfood.application.core.domain.ProductDomain;
import com.fiappostech.fastfood.application.ports.dto.request.ProductRequest;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;
import com.fiappostech.fastfood.application.ports.inbound.ProductSaveInputPort;
import com.fiappostech.fastfood.application.ports.outbound.ProductSaveOutputPort;

public class ProductSaveService implements ProductSaveInputPort{
   
   private final ProductSaveOutputPort productSaveOutputPort;

   public ProductSaveService(ProductSaveOutputPort productSaveOutputPort) {
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