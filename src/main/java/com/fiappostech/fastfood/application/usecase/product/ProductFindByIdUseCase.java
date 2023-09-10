package com.fiappostech.fastfood.application.usecase.product;

import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.product.ProductResponse;

public interface ProductFindByIdUseCase {
   ProductResponse execute(UUID productId);
}