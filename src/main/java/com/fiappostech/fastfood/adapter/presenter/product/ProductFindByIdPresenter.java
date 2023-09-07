package com.fiappostech.fastfood.adapter.presenter.product;

import java.util.UUID;

import com.fiappostech.fastfood.adapter.presenter.product.response.ProductResponseFull;
import com.fiappostech.fastfood.domain.port.product.ProductFindByIdUseCase;

public class ProductFindByIdPresenter {

   private final ProductFindByIdUseCase productFindByIdUseCase;

   public ProductFindByIdPresenter(ProductFindByIdUseCase productFindByIdUseCase) {
      this.productFindByIdUseCase = productFindByIdUseCase;
   }

   public ProductResponseFull execute(UUID productId) {
      return new ProductResponseFull(productFindByIdUseCase.execute(productId));
   }
}