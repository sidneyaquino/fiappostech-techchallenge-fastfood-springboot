package com.fiappostech.fastfood.adapter.presenter.product;

import com.fiappostech.fastfood.adapter.presenter.product.request.ProductPutRequest;
import com.fiappostech.fastfood.adapter.presenter.product.response.ProductResponseFull;

public interface ProductUpdatePresenter {
   public ProductResponseFull execute(ProductPutRequest productPutRequest);
}