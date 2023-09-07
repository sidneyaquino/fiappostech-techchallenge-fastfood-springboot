package com.fiappostech.fastfood.domain.port.product;

import com.fiappostech.fastfood.domain.port.product.dto.ProductRequest;
import com.fiappostech.fastfood.domain.port.product.dto.ProductResponse;

public interface ProductSaveUseCase {
   ProductResponse execute(ProductRequest productRequest);
}