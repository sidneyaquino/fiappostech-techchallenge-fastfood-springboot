package com.fiappostech.fastfood.application.ports.inbound;

import java.util.List;

import com.fiappostech.fastfood.application.ports.dto.ProductCategory;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;

public interface ProductFindByCategoryInputPort {
   List<ProductResponse> execute(ProductCategory category);
}