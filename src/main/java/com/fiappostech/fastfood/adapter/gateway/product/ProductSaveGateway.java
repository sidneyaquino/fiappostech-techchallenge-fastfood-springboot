package com.fiappostech.fastfood.adapter.gateway.product;

import com.fiappostech.fastfood.domain.dto.product.ProductRequest;
import com.fiappostech.fastfood.domain.dto.product.ProductResponse;

public interface ProductSaveGateway {
   ProductResponse execute(ProductRequest productRequest);
}