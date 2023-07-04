package com.fiappostech.fastfood.application.core;

import java.util.UUID;

import com.fiappostech.fastfood.application.ports.inbound.ProductDeleteByIdInputPort;
import com.fiappostech.fastfood.application.ports.outbound.ProductDeleteByIdOutputPort;
import com.fiappostech.fastfood.application.ports.outbound.ProductFindByIdOutputPort;

public class ProductDeleteByIdUseCase implements ProductDeleteByIdInputPort {

   private final ProductDeleteByIdOutputPort productDeleteByIdOutputPort;
   private final ProductFindByIdOutputPort productFindByIdOutputPort;

   public ProductDeleteByIdUseCase(ProductDeleteByIdOutputPort productDeleteByIdOutputPort,
         ProductFindByIdOutputPort productFindByIdOutputPort) {

      this.productDeleteByIdOutputPort = productDeleteByIdOutputPort;
      this.productFindByIdOutputPort = productFindByIdOutputPort;
   }

   @Override
   public void execute(UUID productId) {

      try {
         this.productFindByIdOutputPort.execute(productId);

      } catch (Exception e) {
         throw e;
      }
      ///
      // Business Rules before Request.
      //
      this.productDeleteByIdOutputPort.execute(productId);
      //
      // Business Rules before Response.
      //
   }
}