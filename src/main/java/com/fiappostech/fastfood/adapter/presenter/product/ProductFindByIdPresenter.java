package com.fiappostech.fastfood.adapter.presenter.product;

import java.util.UUID;

import com.fiappostech.fastfood.adapter.presenter.product.response.ProductResponseFull;

public interface ProductFindByIdPresenter {
   public ProductResponseFull execute(UUID productId);
}