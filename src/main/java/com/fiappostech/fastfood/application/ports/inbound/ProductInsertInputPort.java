package com.fiappostech.fastfood.application.ports.inbound;

import com.fiappostech.fastfood.application.ports.dto.request.ProductRequest;
import com.fiappostech.fastfood.application.ports.dto.response.ProductResponse;

public interface ProductInsertInputPort {
   ProductResponse execute(ProductRequest productRequest);
}