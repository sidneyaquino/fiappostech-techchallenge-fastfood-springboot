package com.fiappostech.fastfood.adapter.presenter.product;

import com.fiappostech.fastfood.adapter.presenter.product.request.ProductPostRequest;
import com.fiappostech.fastfood.adapter.presenter.product.response.ProductResponseFull;

public interface ProductInsertPresenter {
   public ProductResponseFull execute(ProductPostRequest productPostRequest);
}