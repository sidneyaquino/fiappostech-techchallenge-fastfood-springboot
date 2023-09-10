package com.fiappostech.fastfood.adapter.presenter.product;

import java.util.UUID;

import com.fiappostech.fastfood.application.usecase.product.ProductDeleteByIdUseCase;

public class ProductDeleteByIdControllerPresenter implements ProductDeleteByIdPresenter {

   private final ProductDeleteByIdUseCase productDeleteByIdUseCase;

   public ProductDeleteByIdControllerPresenter(ProductDeleteByIdUseCase productDeleteByIdUseCase) {
      this.productDeleteByIdUseCase = productDeleteByIdUseCase;
   }

   public void execute(UUID productID) {
      productDeleteByIdUseCase.execute(productID);
   }
}