package com.fiappostech.fastfood.application.port.product;

import com.fiappostech.fastfood.domain.port.product.dto.ProductRequest;
import com.fiappostech.fastfood.domain.port.product.dto.ProductResponse;

public interface ProductSaveGateway {
   ProductResponse execute(ProductRequest productRequest);
}