package com.fiappostech.fastfood.adapter.presenter.product;

import com.fiappostech.fastfood.adapter.presenter.product.request.ProductPostRequest;
import com.fiappostech.fastfood.adapter.presenter.product.response.ProductResponseFull;
import com.fiappostech.fastfood.domain.port.product.ProductSaveUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductInsertPresenter {

   private final ProductSaveUseCase productSaveUseCase;

   public ProductResponseFull execute(ProductPostRequest productPostRequest) {
      var productResponse = productSaveUseCase.execute(productPostRequest.toProductRequest());
      return new ProductResponseFull(productResponse);
   }
}