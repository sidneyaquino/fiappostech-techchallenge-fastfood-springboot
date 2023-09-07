package com.fiappostech.fastfood.application.usecase.product;

import java.util.UUID;

import com.fiappostech.fastfood.application.port.product.ProductDeleteByIdGateway;
import com.fiappostech.fastfood.domain.port.product.ProductDeleteByIdUseCase;

public class ProductDeleteByIdInteractor implements ProductDeleteByIdUseCase {

   private final ProductDeleteByIdGateway productDeleteByIdGateway;

   public ProductDeleteByIdInteractor(ProductDeleteByIdGateway productDeleteByIdGateway) {
      this.productDeleteByIdGateway = productDeleteByIdGateway;
   }

   @Override
   public void execute(UUID productId) {

      ///
      // Business Rules before Request.
      //
      this.productDeleteByIdGateway.execute(productId);
      //
      // Business Rules before Response.
      //
   }
}