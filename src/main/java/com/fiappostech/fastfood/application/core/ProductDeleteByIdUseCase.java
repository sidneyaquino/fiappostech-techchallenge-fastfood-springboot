package com.fiappostech.fastfood.application.core;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.inbound.ProductDeleteByIdInputPort;
import com.fiappostech.fastfood.application.ports.outbound.ProductDeleteByIdOutputPort;

public class ProductDeleteByIdUseCase implements ProductDeleteByIdInputPort {

   private final ProductDeleteByIdOutputPort productDeleteByIdOutputPort;

   public ProductDeleteByIdUseCase(ProductDeleteByIdOutputPort productDeleteByIdOutputPort) {
      this.productDeleteByIdOutputPort = productDeleteByIdOutputPort;
   }

   @Override
   public void execute(UUID productId) {

      ///
      // Business Rules before Request.
      //
      this.productDeleteByIdOutputPort.execute(productId);
      //
      // Business Rules before Response.
      //
   }
}