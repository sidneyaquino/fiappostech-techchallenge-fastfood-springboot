package com.fiappostech.fastfood.adapter.presenter.product;

import java.util.List;

import com.fiappostech.fastfood.adapter.presenter.product.response.ProductResponseFull;
import com.fiappostech.fastfood.application.usecase.product.ProductFindByCategoryUseCase;
import com.fiappostech.fastfood.domain.dto.product.ProductResponse;
import com.fiappostech.fastfood.domain.entity.ProductCategory;

public class ProductFindByCategoryControllerPresenter implements ProductFindByCategoryPresenter {

   private final ProductFindByCategoryUseCase productFindByCategoryUseCase;

   public ProductFindByCategoryControllerPresenter(ProductFindByCategoryUseCase productFindByCategoryUseCase) {
      this.productFindByCategoryUseCase = productFindByCategoryUseCase;
   }

   public List<ProductResponseFull> execute(ProductCategory category) {
      List<ProductResponse> listProductResponse = productFindByCategoryUseCase.execute(category);
      return listProductResponse.stream().map(item -> new ProductResponseFull(item)).toList();
   }
}