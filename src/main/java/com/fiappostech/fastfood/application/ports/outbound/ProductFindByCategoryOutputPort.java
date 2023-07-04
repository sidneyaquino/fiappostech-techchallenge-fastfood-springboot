package com.fiappostech.fastfood.application.ports.outbound;

import java.util.List;

import com.fiappostech.fastfood.application.ports.dto.Category;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;

public interface ProductFindByCategoryOutputPort {
   public List<ProductResponse> execute(Category category);
}
