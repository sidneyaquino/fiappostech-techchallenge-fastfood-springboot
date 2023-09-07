package com.fiappostech.fastfood.domain.port.product;

import java.util.List;

import com.fiappostech.fastfood.domain.entity.ProductCategory;
import com.fiappostech.fastfood.domain.port.product.dto.ProductResponse;

public interface ProductFindByCategoryUseCase {
   List<ProductResponse> execute(ProductCategory category);
}