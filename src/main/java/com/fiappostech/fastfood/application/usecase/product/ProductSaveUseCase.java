package com.fiappostech.fastfood.application.usecase.product;

import com.fiappostech.fastfood.domain.dto.product.ProductRequest;
import com.fiappostech.fastfood.domain.dto.product.ProductResponse;

public interface ProductSaveUseCase {
   ProductResponse execute(ProductRequest productRequest);
}