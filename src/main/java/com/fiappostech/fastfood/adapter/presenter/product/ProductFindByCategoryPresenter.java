package com.fiappostech.fastfood.adapter.presenter.product;

import java.util.List;

import com.fiappostech.fastfood.adapter.presenter.product.response.ProductResponseFull;
import com.fiappostech.fastfood.domain.entity.ProductCategory;
import com.fiappostech.fastfood.domain.port.product.ProductFindByCategoryUseCase;
import com.fiappostech.fastfood.domain.port.product.dto.ProductResponse;

public class ProductFindByCategoryPresenter {

   private final ProductFindByCategoryUseCase productFindByCategoryUseCase;

   public ProductFindByCategoryPresenter(ProductFindByCategoryUseCase productFindByCategoryUseCase) {
      this.productFindByCategoryUseCase = productFindByCategoryUseCase;
   }

   public List<ProductResponseFull> execute(ProductCategory category) {
      List<ProductResponse> listProductResponse = productFindByCategoryUseCase.execute(category);
      return listProductResponse.stream().map(item -> new ProductResponseFull(item)).toList();
   }
}