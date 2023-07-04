package com.fiappostech.fastfood.application.ports.inbound;

import java.util.List;

import com.fiappostech.fastfood.application.ports.dto.Category;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;

public interface ProductFindByCategoryInputPort {
   List<ProductResponse> execute(Category category);
}