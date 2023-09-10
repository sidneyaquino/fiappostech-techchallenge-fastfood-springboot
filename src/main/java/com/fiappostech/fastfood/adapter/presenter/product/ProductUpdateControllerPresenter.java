package com.fiappostech.fastfood.adapter.presenter.product;

import com.fiappostech.fastfood.adapter.presenter.product.request.ProductPutRequest;
import com.fiappostech.fastfood.adapter.presenter.product.response.ProductResponseFull;
import com.fiappostech.fastfood.application.usecase.product.ProductSaveUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductUpdateControllerPresenter implements ProductUpdatePresenter {

   private final ProductSaveUseCase productSaveUseCase;

   public ProductResponseFull execute(ProductPutRequest productPutRequest) {
      var productResponse = productSaveUseCase.execute(productPutRequest.toProductRequest());
      return new ProductResponseFull(productResponse);
   }
}