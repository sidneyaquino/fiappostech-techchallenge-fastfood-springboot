package com.fiappostech.fastfood.adapter.gateway.product;

import java.util.List;

import com.fiappostech.fastfood.domain.dto.product.ProductResponse;
import com.fiappostech.fastfood.domain.entity.ProductCategory;

public interface ProductFindByCategoryGateway {
   public List<ProductResponse> execute(ProductCategory category);
}
