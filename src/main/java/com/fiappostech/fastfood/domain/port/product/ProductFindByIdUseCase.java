package com.fiappostech.fastfood.domain.port.product;

import java.util.UUID;

import com.fiappostech.fastfood.domain.port.product.dto.ProductResponse;

public interface ProductFindByIdUseCase {
   ProductResponse execute(UUID productId);
}