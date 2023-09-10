package com.fiappostech.fastfood.application.usecase.product;

import java.util.List;

import com.fiappostech.fastfood.domain.dto.product.ProductResponse;
import com.fiappostech.fastfood.domain.entity.ProductCategory;

public interface ProductFindByCategoryUseCase {
   List<ProductResponse> execute(ProductCategory category);
}