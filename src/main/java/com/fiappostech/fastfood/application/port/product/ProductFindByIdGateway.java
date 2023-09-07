package com.fiappostech.fastfood.application.port.product;

import java.util.UUID;

import com.fiappostech.fastfood.domain.port.product.dto.ProductResponse;

public interface ProductFindByIdGateway {
   public ProductResponse execute(UUID productId);
}
