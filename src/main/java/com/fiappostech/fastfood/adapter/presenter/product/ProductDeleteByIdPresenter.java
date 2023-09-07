package com.fiappostech.fastfood.adapter.presenter.product;

import java.util.UUID;

import com.fiappostech.fastfood.domain.port.product.ProductDeleteByIdUseCase;

public class ProductDeleteByIdPresenter {

   private final ProductDeleteByIdUseCase productDeleteByIdUseCase;

   public ProductDeleteByIdPresenter(ProductDeleteByIdUseCase productDeleteByIdUseCase) {
      this.productDeleteByIdUseCase = productDeleteByIdUseCase;
   }

   public void execute(UUID productID) {
      productDeleteByIdUseCase.execute(productID);
   }
}