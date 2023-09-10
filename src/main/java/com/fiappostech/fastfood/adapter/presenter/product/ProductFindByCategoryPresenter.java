package com.fiappostech.fastfood.adapter.presenter.product;

import java.util.List;

import com.fiappostech.fastfood.adapter.presenter.product.response.ProductResponseFull;
import com.fiappostech.fastfood.domain.entity.ProductCategory;

public interface ProductFindByCategoryPresenter {
   public List<ProductResponseFull> execute(ProductCategory category);
}