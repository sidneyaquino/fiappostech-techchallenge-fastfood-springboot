package com.fiappostech.fastfood.application.ports.outbound;

import com.fiappostech.fastfood.application.ports.dto.request.ProductRequest;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;

public interface ProductAddOutputPort {
   ProductResponse execute(ProductRequest productRequest);
}