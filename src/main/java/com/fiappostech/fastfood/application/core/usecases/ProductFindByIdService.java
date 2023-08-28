package com.fiappostech.fastfood.application.core.usecases;

import java.util.UUID;

import com.fiappostech.fastfood.application.core.domain.ProductDomain;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;
import com.fiappostech.fastfood.application.ports.inbound.ProductFindByIdInputPort;
import com.fiappostech.fastfood.application.ports.outbound.ProductFindByIdOutputPort;

public class ProductFindByIdService implements ProductFindByIdInputPort {
   
   private final ProductFindByIdOutputPort productFindByIdOutputPort;

   public ProductFindByIdService(ProductFindByIdOutputPort productFindByIdOutputPort) {
      this.productFindByIdOutputPort = productFindByIdOutputPort;
   }

   @Override
   public ProductResponse execute(UUID productId) {
      
      //
      // Business Rules before Request.
      //
      var productResponse = this.productFindByIdOutputPort.execute(productId);
      var productDomain = new ProductDomain(productResponse); 
      //
      // Business Rules before Response.
      //

      return productDomain.toProductResponse();
   }
}