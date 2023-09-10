package com.fiappostech.fastfood.adapter.gateway.product;

import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.product.ProductResponse;

public interface ProductFindByIdGateway {
   public ProductResponse execute(UUID productId);
}
