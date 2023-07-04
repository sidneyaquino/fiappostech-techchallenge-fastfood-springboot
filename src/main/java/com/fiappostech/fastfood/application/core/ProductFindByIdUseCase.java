package com.fiappostech.fastfood.application.core;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;
import com.fiappostech.fastfood.application.ports.inbound.ProductFindByIdInputPort;
import com.fiappostech.fastfood.application.ports.outbound.ProductFindByIdOutputPort;

public class ProductFindByIdUseCase implements ProductFindByIdInputPort {
   
   private final ProductFindByIdOutputPort productFindByIdOutputPort;

   public ProductFindByIdUseCase(ProductFindByIdOutputPort productFindByIdOutputPort) {
      this.productFindByIdOutputPort = productFindByIdOutputPort;
   }

   @Override
   public ProductResponse execute(UUID productId) {
      
      //
      // Business Rules before Request.
      //
      var productResponse = this.productFindByIdOutputPort.execute(productId);
      //
      // Business Rules before Response.
      //

      return productResponse;
   }
}