package com.fiappostech.fastfood.adapter.presenter.product;

import java.util.UUID;

import com.fiappostech.fastfood.adapter.presenter.product.response.ProductResponseFull;
import com.fiappostech.fastfood.application.usecase.product.ProductFindByIdUseCase;

public class ProductFindByIdControllerPresenter implements ProductFindByIdPresenter {

   private final ProductFindByIdUseCase productFindByIdUseCase;

   public ProductFindByIdControllerPresenter(ProductFindByIdUseCase productFindByIdUseCase) {
      this.productFindByIdUseCase = productFindByIdUseCase;
   }

   public ProductResponseFull execute(UUID productId) {
      return new ProductResponseFull(productFindByIdUseCase.execute(productId));
   }
}