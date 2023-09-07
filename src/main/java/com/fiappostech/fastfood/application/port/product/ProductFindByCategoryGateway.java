package com.fiappostech.fastfood.application.port.product;

import java.util.List;

import com.fiappostech.fastfood.domain.entity.ProductCategory;
import com.fiappostech.fastfood.domain.port.product.dto.ProductResponse;

public interface ProductFindByCategoryGateway {
   public List<ProductResponse> execute(ProductCategory category);
}
